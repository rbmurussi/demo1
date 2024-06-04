package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_VOTE")
public class Vote {

    @EmbeddedId
    private VotePk id;

    @Column(name = "VOTE")
    private boolean vote;

    public Vote() {}

    public Vote(VotePk id, boolean vote) {
        this.id = id;
        this.vote = vote;
    }

    public VotePk getId() {
        return id;
    }

    public void setId(VotePk id) {
        this.id = id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

}
