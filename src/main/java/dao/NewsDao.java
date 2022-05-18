package dao;

import models.News;

import java.util.List;

public interface NewsDao {
    //CRUD functionality

    // CREATE
    void add(News news);

    // READ
    List<News> getAll();
    News findById(int id);


    // UPDATE


    // DELETE
    void delete(int id);
    void deleteAll();

}
