package com.raga.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name = "qb_option")
public class Option {

    @Id
    private String id;
    private String text;
    private Timestamp addedDate;
    private Timestamp lastUpdatedDate;
    private CorrectOption correctOption;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @SuppressWarnings("unused")
    private Option() {
    }

    public Option(String id, String text, Timestamp addedDate, Timestamp lastUpdatedDate,
                  CorrectOption correctOption, Question question) {
        this.id = id;
        this.text = text;
        this.addedDate = addedDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.correctOption = correctOption;
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public CorrectOption getCorrectOption() {
        return correctOption;
    }

    @JsonIgnore
    public Question getQuestion() {
        return question;
    }
}
