package com.tp.repository;

import com.tp.model.User;

public interface UserRepository extends GenericRepository<User, Long> {
    User findByUsername(String username);
}
