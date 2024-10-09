package com.tp.repository.impl;

import com.tp.model.User;
import com.tp.repository.UserRepository;
import jakarta.persistence.EntityManager;

public class JpaUserRepository extends JpaGenericRepository<Long,User > {

     public JpaUserRepository() {
          super();
          this.setClazz(User.class);
     }



}
