package repositories;

import java.util.List;

public interface CrudRepository<T, V> {
    void save(T model);

    void update(T model);

    boolean delete(V id);

    T findOne(V id);

    List<T> findAll();
}
