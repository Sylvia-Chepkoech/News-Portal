package dao;

import models.Employees;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {

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
    public void add(News news) {
        getDrivers();
        String insertQuery = "INSERT INTO news (heading, context, departmentId) VALUES (:heading, :context, :departmentId)";
        try (Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(insertQuery, true)
                    .addParameter("heading", news.getHeading())
                    .addParameter("context", news.getContext())
                    .addParameter("departmentId", news.getDepartmentId())
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<News> getAll() {
        getDrivers();
        String sql = "SELECT * FROM news";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
            }

        }
    @Override
    public void delete(int id) {
        getDrivers();
        String deleteQuery = "DELETE from news WHERE id=:id";
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
        String sql = "DELETE from news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }

    }
}
