package com.mftplus.orm.model.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaProvider {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("mft");

    private JpaProvider() {
    }
    private static final JpaProvider jpaProvider = new JpaProvider();
    public static JpaProvider getJpa(){
        return jpaProvider;
    }
    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
