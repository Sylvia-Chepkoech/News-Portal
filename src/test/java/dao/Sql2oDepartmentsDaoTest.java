package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class Sql2oDepartmentsDaoTest {
    private Sql2oDepartmentsDao sql2oDepartmentsDao;
    private Connection conn;

    @BeforeEach
    void setUp() {

     Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal_test", "chechesylvia", "0718500898");
    sql2oDepartmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
    }
}