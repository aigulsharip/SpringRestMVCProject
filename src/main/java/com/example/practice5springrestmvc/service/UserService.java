package com.example.practice5springrestmvc.service;

import com.example.practice5springrestmvc.entity.User;

public interface UserService {

    public User getUserById(Integer id);

    public User saveUser(User user);
}
