package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.Optional;

class UserServiceImplTest {

    @Test
    void getUserById() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        String cpf = "19839091069";
        User user = new User();
        Mockito.when(userRepository.findById(cpf)).thenReturn(Optional.of(user));
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        User result = userService.getUserById(cpf);
        Assert.notNull(result, "User not found");
    }
}