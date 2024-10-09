package com.tp.repository.impl;

import com.tp.model.GameSession;
import com.tp.model.Player;

public class JpaPlayerRepository extends JpaGenericRepository<Long , Player>{
    public JpaPlayerRepository() {
        super();
        this.setClazz(Player.class);
    }

}
