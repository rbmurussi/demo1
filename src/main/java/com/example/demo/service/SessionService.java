package com.example.demo.service;

public interface SessionService {
    long open(int minutes, String title);

    String vote(Long idSession, String cpf, String yesOrNo);

    String result(Long idSession);
}
