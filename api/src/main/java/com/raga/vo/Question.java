package com.raga.vo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "qb_question")
public class Question {

    @Id
    private String id;
    private String text;
    private Timestamp addedDate;
    private Timestamp lastUpdatedDate;

    @OneToMany(mappedBy = "question", cascade = ALL, fetch = LAZY)
    private Set<Option> options;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "submitter_id", nullable = false)
    private User user;

    @SuppressWarnings("unused")
    private Question() {
    }

    public Question(String id, String text, Timestamp addedDate, Timestamp lastUpdatedDate,
                    Topic topic, Level level, User user) {
        this.id = id;
        this.text = text;
        this.addedDate = addedDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.topic = topic;
        this.level = level;
        this.user = user;
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

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Topic getTopic() {
        return topic;
    }

    public Level getLevel() {
        return level;
    }

    public User getUser() {
        return user;
    }
}
