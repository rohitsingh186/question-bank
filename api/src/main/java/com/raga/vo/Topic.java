package com.raga.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "qb_topic")
public class Topic {

    @Id
    private String id;
    private String name;
    private Timestamp addedDate;

    @OneToMany(mappedBy = "topic", cascade = ALL, fetch = LAZY)
    private Set<Question> questions;

    @SuppressWarnings("unused")
    private Topic() {
    }

    public Topic(String id, String name, Timestamp addedDate) {
        this.id = id;
        this.name = name;
        this.addedDate = addedDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    @JsonIgnore
    public Set<Question> getQuestions() {
        return questions;
    }
}
