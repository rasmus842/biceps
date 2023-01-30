package ee.biceps.api.db.dao;

import java.util.List;

public interface DatabaseModelAccessor<T, ID> {
    T findById(ID id);

    List<T> findAll();

    boolean insert(T entity);

    void batchInsert(List<T> entities);

    boolean updateById(ID id, T entity);

    boolean deleteById(ID id);
}
