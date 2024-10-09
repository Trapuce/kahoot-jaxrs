package com.tp.repository.impl;

import com.tp.repository.EntityManagerHelper;
import com.tp.repository.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class JpaGenericRepository<K, T extends Serializable>  implements GenericRepository<K, T> {

    private Class<T> clazz;

    protected EntityManager entityManager;

    public JpaGenericRepository() {
        this.entityManager = EntityManagerHelper.getEntityManager();
    }

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(K id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("select e from " + clazz.getName() + " as e",clazz).getResultList();
    }

    public void save(T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();

    }

    public T update(final T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        T res = entityManager.merge(entity);
        t.commit();
        return res;

    }

    public void delete(T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();

    }

    public void deleteById(K entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}