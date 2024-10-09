package com.tp.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<K, T extends Serializable> {
    T findOne(final K id);

    List<T> findAll();

    void save(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final K entityId);
}
