package com.example.springrestmvc.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetId() {
        Integer id = 1;
        user.setId(id);
        assertEquals(id, user.getId(), "testGetId failed");
    }

    @Test
    public void testSetName() {
        String name = "testName";
        user.setName(name);
        assertEquals(name, user.getName(), "testSetName failed");
    }

    @Test
    public void testSetEmail() {
        String email = "test@gmail.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail(), "testSetEmail failed");
    }

    @Test
    public void testSetGender() {
        String gender = "Male";
        user.setGender(gender);
        assertEquals(gender, user.getGender(), "testSetGender failed");
    }

    @Test
    public void testSetPhone() {
        String phone = "1234567890";
        user.setPhone(phone);
        assertEquals(phone, user.getPhone(), "testSetPhone failed");
    }


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
