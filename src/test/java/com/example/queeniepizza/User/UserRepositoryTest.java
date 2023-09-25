package com.example.queeniepizza.User;

import com.example.queeniepizza.QueeniePizzaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ComponentScan
@ContextConfiguration(classes = QueeniePizzaApplication.class)
@EnableAutoConfiguration
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        userRepository.save(User.builder().
                userName("queenie").
                password("peter").build());
        assertEquals(1, userRepository.count());
    }
}

