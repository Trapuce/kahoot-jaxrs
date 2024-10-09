package com.tp.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class BaseRepository<T> {

    private final EntityManager manager;
    private final Class<T> entityClass;

    public BaseRepository(EntityManager manager, Class<T> entityClass) {
        this.manager = manager;
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }

        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(entity);
            tx.commit();
            System.out.println("Entity persisted successfully.");
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error persisting entity: " + e.getMessage());
            throw e;
        } finally {
            
        }
    }


    public T find(Long id) {
        return manager.find(entityClass, id);
    }

    public void update(T entity) {
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(entity);
            tx.commit();
            System.out.println("Entity updated successfully.");
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error updating entity: " + e.getMessage());
            throw e; 
        }
    }
    public T findAll() {
        try {
            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            TypedQuery<T> query = manager.createQuery(jpql, entityClass);
            return (T) query.getResultList();
        } catch (PersistenceException e) {
            System.err.println("Error finding all entities: " + e.getMessage());
            throw e;
        }
    }

    public void delete(Long id) {
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            T entity = manager.find(entityClass, id);
            if (entity != null) {
                manager.remove(entity);
            }
            tx.commit();
            System.out.println("Entity deleted successfully.");
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error deleting entity: " + e.getMessage());
            throw e; 
        }
    }
}
