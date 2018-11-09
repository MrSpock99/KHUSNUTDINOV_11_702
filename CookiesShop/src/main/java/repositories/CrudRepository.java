package repositories;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();

    T find(Long id);

    void save(T model);

    void delete(Long id);

    void update(T model);
}
