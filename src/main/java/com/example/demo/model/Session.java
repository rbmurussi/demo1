package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_SESSION")
public class Session {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_SESSION"
    )
    @SequenceGenerator(
            name = "SEQ_SESSION",
            allocationSize = 5
    )
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SESSION")
    private Date session;

    @Column(name = "MINUTES")
    private int minutes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSession() {
        return session;
    }

    public void setSession(Date session) {
        this.session = session;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
