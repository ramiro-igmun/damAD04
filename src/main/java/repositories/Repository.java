package repositories;

import java.util.List;

public interface Repository<T> {
    Class<T> getClazz();
    /**
     * Persist the entity in the db
     * @param entity to persist
     */
    void save(T entity);
    /**
     * Delete a persisted entity by id
     * @param id of the entity to delete
     */
    void deleteById(int id);
    /**
     * Return the persistent instance of the given entity class with the given identifier
     * @param id of the entity to fetch
     * @return the instance of the entity
     */
    T getById(int id);

    /**
     * Fetch all the persisted instances
     * @return a List with all the instances in db
     */
    List<T> getAll();
}
