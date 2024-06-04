package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ABLE")
    private Boolean able;

    public User() {}

    public User(String cpf, String name, Boolean able) {
        this.cpf = cpf;
        this.name = name;
        this.able = able;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAble() {
        return able;
    }

    public void setAble(Boolean able) {
        this.able = able;
    }
}
