package com.example.springrestmvc.service;

import com.example.springrestmvc.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    User saveUser(User user);

    List<User> getAllUsers ();
}
