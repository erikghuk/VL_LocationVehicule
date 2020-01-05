package com.erik.model.DB;
import java.sql.Connection;
import java.util.List;

public interface  DAO<T> {
    Connection connect = ConectionPostgreSQL.getInstance();
    List<T> getAllData();
    T create(T obj);
    T read(int id);
    T update(T obj);
    void delete(T obj);
}
