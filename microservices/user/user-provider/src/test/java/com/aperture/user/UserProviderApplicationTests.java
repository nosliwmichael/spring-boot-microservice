package com.aperture.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import com.aperture.user.controller.UserController;
import com.aperture.user.remote.UserRemote;

@SpringBootTest
@TestPropertySource(locations = "classpath:UserProviderApplicationTests.properties")
public class UserProviderApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllUsers_ReturnAllUsers() {
        List<UserRemote> users = userController.getAllUsers();
        Assert.notNull(users, "UserService returned null.");
        Assert.notEmpty(users,"UserService returned an empty list.");
    }

    @Test
    void getUserById_ReturnSingleUser() {
        UserRemote user = userController.getUserById(1L);
        Assert.notNull(user, "UserService returned null.");
    }

    @Test
    void getUserById_ReturnsNull() {
        UserRemote user = userController.getUserById(4L);
        Assert.isNull(user, "UserService returned something.");
    }

}