package org.example.simpleBankSystem.serviceImpl;

import org.example.simpleBankSystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void getUserByLogin() {
        System.out.println(userService.getUserByLogin("user").getLogin());
        assertNotNull(userService.getUserByLogin("user"));
    }

    @Test
    void addUser() {
    }

    @Test
    void loadUserByUsername() {

    }
}