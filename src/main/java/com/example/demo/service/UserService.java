package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    String getAbleToVote(String cpf);

    User getAll(String cpf);

    User save(String cpf, String name, Boolean able);
}
