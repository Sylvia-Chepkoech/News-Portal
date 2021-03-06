import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oEmployeesDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Departments;
import models.Employees;
import models.News;
import org.h2.store.LimitInputStream;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        Gson gson = new Gson();
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal", "chechesylvia", "0718500898");
        Sql2oDepartmentsDao sql2oDepartmentsDao = new Sql2oDepartmentsDao(sql2o);
        Sql2oEmployeesDao sql2oEmployeesDao = new Sql2oEmployeesDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);

        //create new employee
        post("/employee/new", "application/json", ((request, response) -> {
            Employees firstEmployee = gson.fromJson(request.body(),Employees.class);

            if (firstEmployee != null){
                sql2oEmployeesDao.add(firstEmployee);
                response.status(201);
                return gson.toJson(firstEmployee);
            } else {
                throw new ApiException("Please do not leave empty fields", 404);
            }
        }));

        //list all employees
        get("/employee", "application/json", ((request, response) -> {
            List<Employees> users = sql2oEmployeesDao.getAll();
            response.status(200);
            return gson.toJson(users);
        }));

        //find employees by Id
        get("/employee/:id", "application/json", ((request, response) -> {
         int employeeId = Integer.parseInt(request.params("id"));
         Employees user = sql2oEmployeesDao.findById(employeeId);
         if (user != null){
             response.status(201);
             return gson.toJson(user);
         }else {
             throw new ApiException(String.format("No Employee with the id: \"%s\" exists", request.params("id")), 404);
         }
    }));

        //create new department
        post("/department/new", "application/json", ((request, response) -> {

            Departments sections = gson.fromJson(request.body(),Departments.class);

            if (sections == null){
                throw new ApiException("Please do not leave empty fields", 404);

            } else if(sections.getDepartmentName().equals("") || sections.getDescription().equals("")){
                throw new ApiException("Please do not leave empty fields", 404);

            }else if (sql2oDepartmentsDao.getAll().contains(sections)){
                throw new ApiException("The department already exist", 404);

            }
            else {sql2oDepartmentsDao.add(sections);
                response.status(201);
                return gson.toJson(sections);}
        }));


        //list all departments
        get("/department", "application/json", ((request, response) -> {
                    List<Departments> sectors = sql2oDepartmentsDao.getAll();
                    response.status(200);
                    return gson.toJson(sectors);
                }));

//        //Find employees in a department
//        get("/departments/:departmentId/employees", "application/json", (request, response) -> {
//            int departmentId = Integer.parseInt(request.params("departmentId"));
//            return  gson.toJson(sql2oDepartmentsDao.getAll(departmentId));
//        });

        //Create news
        post("/report/new", "application/json", ((request, response) -> {

            News report = gson.fromJson(request.body(), News.class);

            if (report == null){
                throw new ApiException("Please do not leave empty fields", 404);

            } else if(report.getContext().equals("") || report.getHeading().equals("")){
                throw new ApiException("Please do not leave empty fields", 404);

            }else if (sql2oNewsDao.getAll().contains(report)){
                throw new ApiException("This news already exist", 404);

            }
            else {sql2oNewsDao.add(report);
                response.status(201);
                return gson.toJson(report);}
        }));


        //list all news
            get("/news", "application/json", (request, response) -> {
                List<News> reports = sql2oNewsDao.getAll();
                response.status(200);
                        return gson.toJson(reports);
                    });

        //list news in a department






        exception(ApiException.class, (exc, req, res) -> {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", ((ApiException) exc).getStatusCode());
            jsonMap.put("errorMessage", ((ApiException) exc).getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(((ApiException) exc).getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((req,res)-> res.type("application/json"));
    }
        }

