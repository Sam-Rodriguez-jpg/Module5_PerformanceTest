package interfaces;

import java.util.List;

public interface CRUD<T> {
    void create(T entity);
    List<T> findAll();
    T findById(int id);
    void update(T entity);
    void delete(T entity);
}
