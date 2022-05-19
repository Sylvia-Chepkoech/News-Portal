package dao;

import models.Departments;
import models.Employees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEmployeesDao implements EmployeesDao{
    private final Sql2o sql2o;

    public Sql2oEmployeesDao(Sql2o sql2o) {

        this.sql2o = sql2o;
    }

    public void getDrivers() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add(Employees employees) {
        getDrivers();
        String insertQuery = "INSERT INTO employees (name, position, email, departmentId) VALUES (:name, :position, :email, :departmentId)";
        try (Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(insertQuery, true)
                    .addParameter("name", employees.getName())
                    .addParameter("position", employees.getPosition())
                    .addParameter("email", employees.getEmail())
                    .addParameter("departmentId", employees.getDepartmentId())
                    .executeUpdate()
                    .getKey();
            employees.setId(id);
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public List<Employees> getAll() {
        getDrivers();
        String sql = "SELECT * FROM employees";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Employees.class);
        }
    }


    @Override
    public Employees findById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM employees WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Employees.class);
        }

    }

    @Override
    public void delete(int id) {
        getDrivers();
        String deleteQuery = "DELETE from employees WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(deleteQuery)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void deleteAll() {
        getDrivers();
        String sql = "DELETE from employees";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }

    }
}
