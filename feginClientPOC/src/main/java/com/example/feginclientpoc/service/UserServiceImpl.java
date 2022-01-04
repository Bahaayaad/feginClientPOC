package com.example.feginclientpoc.service;
import com.example.feginclientpoc.client.UserMockClient;
import com.example.feginclientpoc.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMockClient userMockClient;

    @Override
    public List<User> getAllUsers() {
        return userMockClient.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userMockClient.getUserById(id);
    }

    @Override
    public Long createUser(User user) {
        return userMockClient.createUser(user);
    }

    @Override
    public boolean updateUser(Long id, User user) {
        return userMockClient.updateUser(id, user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userMockClient.deleteUserById(id);
    }
}