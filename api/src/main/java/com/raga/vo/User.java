package com.raga.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "qb_user")
public class User {

    @Id
    private String id;
    private String userName;
    private String fullName;

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY)
    private Set<Question> questions;

    @SuppressWarnings("unused")
    private User() {
    }

    public User(String id, String userName, String fullName) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    @JsonIgnore
    public Set<Question> getQuestions() {
        return questions;
    }
}
