package com.example.feginclientpoc.service;

import java.util.List;
import com.example.feginclientpoc.domain.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    Long createUser(User user);

    boolean updateUser(Long id, User user);

    boolean deleteUserById(Long id);
}