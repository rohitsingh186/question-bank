package com.raga.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "qb_level")
public class Level {

    @Id
    private String id;
    private String code;
    private Timestamp addedDate;

    @OneToMany(mappedBy = "level", cascade = ALL, fetch = LAZY)
    private Set<Question> questions;

    @SuppressWarnings("unused")
    private Level() {
    }

    public Level(String id, String code, Timestamp addedDate) {
        this.id = id;
        this.code = code;
        this.addedDate = addedDate;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    @JsonIgnore
    public Set<Question> getQuestions() {
        return questions;
    }
}
