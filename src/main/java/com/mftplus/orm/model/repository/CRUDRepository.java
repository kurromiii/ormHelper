package com.mftplus.orm.model.repository;

import com.mftplus.orm.model.utils.JpaProvider;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CRUDRepository<T> implements AutoCloseable{
    protected EntityManager entityManager;
    public CRUDRepository(){
        entityManager = JpaProvider.getJpa().getEntityManager();
    }

    public T save(T t){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(t);
        entityTransaction.commit();
        return t;
    }
    public T edit(T t){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(t);
        entityTransaction.commit();
        return t;
    }
    public T remove(Class<T> tClass,int id){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T t = (T) entityManager.find(tClass,id);
        entityManager.remove(t);
        entityTransaction.commit();
        return t;
    }
    public T findById(Class<T> tClass,int id){
        return (T) entityManager.find(tClass,id);
    }
    public List<T> findAll(Class<T> tClass){
        Query query = entityManager.createQuery
                ("select oo from " +tClass.getAnnotation(Entity.class).name()+ " oo");
        return (List<T>) query.getResultList();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
