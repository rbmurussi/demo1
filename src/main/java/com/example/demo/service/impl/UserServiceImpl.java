package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.BrazilUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String cpf) {
        if(!BrazilUtils.isValidateCPF(cpf)) {
            throw new IllegalArgumentException("CPF invalid!");
        }
        return userRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Cant find user by id " + cpf));
    }

    public String getAbleToVote(String cpf) {
        try {
            User user = getUserById(cpf);
            if(user.getAble()) {
                return BrazilUtils.ABLE;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return BrazilUtils.NOT_ABLE;
    }

    @Override
    public User getAll(String cpf) {
        return getUserById(cpf);
    }

    @Override
    public User save(String cpf, String name, Boolean able) {
        User user = new User(cpf, name, able);
        return userRepository.save(user);
    }
}
