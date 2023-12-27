package com.example.springrestmvc.entity;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class UserTest {

    @Test
     void testUserInitialization() {
        User user = new User(1, "Test Name", "test@test.com", "Female", "1234567890");

        assertEquals(1, user.getId());
        assertEquals("Test Name", user.getName());
        assertEquals("test@test.com", user.getEmail());
        assertEquals("Female", user.getGender());
        assertEquals("1234567890", user.getPhone());
    }

    @Test
     void testUserSetters() {
        User user = new User();
        user.setName("Another Test Name");
        user.setEmail("another@test.com");
        user.setGender("Male");
        user.setPhone("0987654321");

        assertEquals("Another Test Name", user.getName());
        assertEquals("another@test.com", user.getEmail());
        assertEquals("Male", user.getGender());
        assertEquals("0987654321", user.getPhone());
    }
}
