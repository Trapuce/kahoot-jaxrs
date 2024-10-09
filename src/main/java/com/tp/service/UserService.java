package com.tp.service;

import com.tp.dto.UserDTO;
import com.tp.mappers.UserMapper;
import com.tp.model.User;
import com.tp.repository.UserRepository;
import com.tp.repository.impl.JpaUserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final JpaUserRepository jpaUserRepository;
    private  final UserMapper userMapper = UserMapper.INSTANCE;
    public UserService() {
        this.jpaUserRepository = new JpaUserRepository();
    }



    public User getUserById(Long userId) {
        User user = this.jpaUserRepository.findOne(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found for ID: " + userId);
        }
        return user;
    }


    public List<User> getAllUsers() {
        List<User> users = this.jpaUserRepository.findAll();
         return  users ;
    }


    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        user.setCreatedAt(new Date());
        this.jpaUserRepository.save(user);
        return userMapper.userToUserDTO(user) ;
    }


    public User updateUser(User user) {
        User user1 = this.jpaUserRepository.findOne(user.getId());
        if (user1 == null) {
            throw new IllegalArgumentException("User not found for ID: " + user.getId());
        }

        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());

        jpaUserRepository.update(user);
        return user1;
    }

    public void deleteUser(Long userId) {
        if (jpaUserRepository.findOne(userId) == null) {
            throw new IllegalArgumentException("User not found for ID: " + userId);
        }
        jpaUserRepository.deleteById(userId);
    }
}
