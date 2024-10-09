package com.tp.repository.impl;

import com.tp.model.Question;

public class JpaQuestionRepository extends JpaGenericRepository<Long , Question> {

    public JpaQuestionRepository() {
         super();
         this.setClazz(Question.class);
    }
}
