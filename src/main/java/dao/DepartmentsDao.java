package dao;

import models.Departments;


import java.util.List;

public interface DepartmentsDao {
    //CRUD functionality

    // CREATE
    void add(Departments departments);

    // READ
    List<Departments> getAll();
    Departments findById(int id);


    // UPDATE


    // DELETE
    void delete(int id);
    void deleteAll();
}
