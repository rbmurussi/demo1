package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ResultSession {

    @Id
    private boolean vote;

    private long count;

    public ResultSession() {}

    public ResultSession(boolean vote, long count) {
        this.vote = vote;
        this.count = count;
    }

    public boolean isVote() {
        return vote;
    }

    public long getCount() {
        return count;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResultSession{" +
                "vote=" + vote +
                ", count=" + count +
                '}';
    }
}
