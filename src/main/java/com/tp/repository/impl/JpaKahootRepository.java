package com.tp.repository.impl;

import com.tp.model.Kahoot;
import com.tp.model.User;
import jakarta.persistence.EntityManager;

public class JpaKahootRepository extends JpaGenericRepository<Long , Kahoot> {
    public JpaKahootRepository() {
        super();
        this.setClazz(Kahoot.class);
    }
}
