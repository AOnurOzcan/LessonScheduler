package com.lessonscheduler.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


public class GenericDao<T> {

    Class<T> className;

    @PersistenceContext
    public EntityManager entityManager;

    public GenericDao(Class<T> className) {
        this.className = className;
    }

    public T persist(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T merge(T entity) {
        entityManager.merge(entity);
        return entity;
    }

    public T remove(T entity) {
        entityManager.remove(entity);
        return entity;
    }

    public List<T> findAll() {

        return entityManager.createQuery(
                "from " + className.getName() + "  i order by i.id").getResultList();
    }

    public T find(int id) {
        T e = entityManager.find(className, id);
        return e;
    }

    public T find(long id) {
        T e = entityManager.find(className, id);
        return e;
    }

    public T find(String id) {
        T e = entityManager.find(className, id);
        return e;
    }
}