package com.tp.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaTest {
    public static void main(String[] args) {
        EntityManagerFactory emfMySQL = Persistence.createEntityManagerFactory("mysql");
        EntityManager emMySQL = emfMySQL.createEntityManager();


        emMySQL.close();
        emfMySQL.close();
    }
}



