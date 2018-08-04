package com.raga.controller;

import com.raga.repository.TopicRepository;
import com.raga.vo.Topic;
import com.raga.vo.request.AddTopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.raga.util.ClockUtil.now;
import static java.util.UUID.randomUUID;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * File: QuestionController
 * Created by Rohit Singh on 04-10-2017.
 */

@RestController
@RequestMapping("/topics")
public class TopicController {
    private TopicRepository repository;

    @Autowired
    public TopicController(TopicRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public Iterable<Topic> getTopics() {
        return repository.findAll();
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public void addTopic(@RequestBody AddTopicRequest request) {
        Topic topic = new Topic(randomUUID().toString(), request.getName(), now());
        repository.save(topic);
    }
}
