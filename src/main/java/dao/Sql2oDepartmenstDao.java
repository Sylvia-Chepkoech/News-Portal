package dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmenstDao implements DepartmentsDao {

    private final Sql2o sql2o;

    public Sql2oDepartmenstDao(Sql2o sql2o) {
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
    public void add(Departments departments) {
        getDrivers();
        String insertQuery = "INSERT INTO departments (departmentName, description, numberOfEmployees) VALUES (:departmentName, :description, :numberOfEmployees)";
        try (Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(insertQuery, true)
                    .addParameter("departmentName", departments.getDepartmentName() )
                    .addParameter("description", departments.getDescription())
                    .addParameter("numberOfEmployees", departments.getNumberOfEmployees())
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public List<Departments> getAll() {
        getDrivers();
        String sql = "SELECT * FROM departments";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public Departments findById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public void delete(int id) {
        getDrivers();
        String deleteQuery = "DELETE from departments WHERE id=:id";
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
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }
}

