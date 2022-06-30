package com.fileExplorer.user.services;

import com.fileExplorer.user.model.User;
import com.fileExplorer.user.model.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void addUserTest() {

        UserDTO user = new UserDTO();
        user.setPassword("deneme");
        user.setUsername("deneme");

        UserDTO result = userService.addUser(user);
        System.out.println(result);
    }


    @Test
    void findByUsername() {

        String username = "deneme";

        User result = userService.findByUsername(username);

        System.out.println(result);
    }
}