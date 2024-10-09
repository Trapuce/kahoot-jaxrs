package com.tp.repository.impl;

import com.tp.model.Answer;
import com.tp.model.GameSession;

public class JpaAnswerRepository extends JpaGenericRepository<Long , Answer>{

    public JpaAnswerRepository() {
        super();
        this.setClazz(Answer.class);
    }
}
