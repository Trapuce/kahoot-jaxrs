package com.tp.repository.impl;

import com.tp.model.GameSession;
import com.tp.model.User;
import jakarta.persistence.EntityManager;

public class JpaGameSessionRepository extends JpaGenericRepository<Long ,GameSession>{

    public JpaGameSessionRepository() {
        super();
        this.setClazz(GameSession.class);
    }


}
