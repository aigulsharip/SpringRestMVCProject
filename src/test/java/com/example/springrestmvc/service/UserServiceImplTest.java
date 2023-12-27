package com.example.springrestmvc.service;

import com.example.springrestmvc.entity.User;
import com.example.springrestmvc.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testGetUserById() {
        User user = new User(1, "Test Name", "test@test.com", "Female", "1234567890");
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals("Test Name", result.getName());
    }

    @Test
     void testSaveUser() {
        User user = new User(1, "Test Name", "test@test.com", "Female", "1234567890");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);
        assertNotNull(savedUser);
        assertEquals("Test Name", savedUser.getName());
    }

    @Test
     void testGetAllUsers() {
        User user1 = new User(1, "Test Name 1", "test1@test.com", "Female", "1234567891");
        User user2 = new User(2, "Test Name 2", "test2@test.com", "Male", "1234567892");

        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> userList = userService.getAllUsers();
        assertEquals(2, userList.size());
    }
}