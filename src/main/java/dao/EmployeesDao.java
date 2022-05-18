package dao;

import models.Employees;


import java.util.List;

public interface EmployeesDao {

    //CRUD functionality

    // CREATE
    void add(Employees employees);

    // READ
    List<Employees> getAll();
    Employees findById(int id);


    // UPDATE


    // DELETE
    void delete(int id);
    void deleteAll();
}
