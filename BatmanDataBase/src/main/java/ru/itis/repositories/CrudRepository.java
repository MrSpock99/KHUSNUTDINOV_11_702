package ru.itis.repositories;

import java.util.List;

public interface CrudRepository<T, V> {
    boolean save(T model);

    void update(T model);

    boolean delete(V id);

    T findOne(V id);

    List<T> findAll();
}
