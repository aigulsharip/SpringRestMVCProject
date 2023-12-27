package com.example.springrestmvc.controllers;

import com.example.springrestmvc.controllers.UserController;
import com.example.springrestmvc.entity.User;
import com.example.springrestmvc.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    void testGetAllUsers() {
        // Arrange
        List<User> mockUsers = Arrays.asList(
                new User(1, "John", "john@example.com", "Male", "123456789"),
                new User(2, "Jane", "jane@example.com", "Female", "987654321")
        );
        when(userService.getAllUsers()).thenReturn(mockUsers);

        // Act
        List<User> result = userController.getAllUsers();

        // Assert
        assertEquals(mockUsers.size(), result.size());
        assertEquals(mockUsers, result);
        verify(userService, times(1)).getAllUsers();
    }

    @Test
     void testGetUserById() {
        // Arrange
        Integer userId = 1;
        User mockUser = new User(userId, "John", "john@example.com", "Male", "123456789");
        when(userService.getUserById(userId)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> result = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(mockUser, result.getBody());
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
     void testSaveUser() {
        // Arrange
        User newUser = new User(null, "NewUser", "newuser@example.com", "Female", "987654321");
        User savedUser = new User(1, "NewUser", "newuser@example.com", "Female", "987654321");
        when(userService.saveUser(newUser)).thenReturn(savedUser);

        // Act
        ResponseEntity<User> result = userController.saveUser(newUser);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(savedUser, result.getBody());
        verify(userService, times(1)).saveUser(newUser);
    }
}
