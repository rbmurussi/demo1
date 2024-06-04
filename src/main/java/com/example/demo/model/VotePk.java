package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class VotePk {

    @Column(name = "ID_SESSION")
    private long idSession;

    @Column(name = "CPF")
    private String cpf;

    public VotePk() {}

    public VotePk(long idSession, String cpf) {
        this.idSession = idSession;
        this.cpf = cpf;
    }

    public long getIdSession() {
        return idSession;
    }

    public void setIdSession(long idSession) {
        this.idSession = idSession;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
