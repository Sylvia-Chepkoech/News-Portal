package dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmenstDao implements DepartmentsDao{

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

    }

    @Override
    public List<Departments> getAll() {
        return null;
    }

    @Override
    public Departments findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    getDrivers();
    String sql = "DELETE from ";
        try (Connection con = sql2o.open()) {
        con.createQuery(sql)
                .executeUpdate();
    } catch (
    Sql2oException e) {
        System.out.println(e);
    }
}
}
