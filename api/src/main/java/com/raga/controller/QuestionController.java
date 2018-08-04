package com.raga.controller;

import com.raga.repository.LevelRepository;
import com.raga.repository.QuestionRepository;
import com.raga.repository.TopicRepository;
import com.raga.repository.UserRepository;
import com.raga.vo.Option;
import com.raga.vo.Question;
import com.raga.vo.request.AddQuestionRequest;
import com.raga.vo.request.OptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import static com.raga.util.ClockUtil.now;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toSet;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * File: QuestionController
 * Created by Rohit Singh on 04-10-2017.
 */

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private TopicRepository topicRepository;
    private LevelRepository levelRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionController(TopicRepository topicRepository, LevelRepository levelRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.topicRepository = topicRepository;
        this.levelRepository = levelRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public void addQuestion(@RequestBody AddQuestionRequest addQuestionRequest) {
        Timestamp now = now();
        Question question = new Question(randomUUID().toString(), addQuestionRequest.getText(), now, now,
                topicRepository.findOne(addQuestionRequest.getTopicId()),
                levelRepository.findOne(addQuestionRequest.getLevelId()),
                userRepository.findOne(addQuestionRequest.getSubmitterId()));
        Set<Option> options = getOptions(addQuestionRequest.getOptionRequests(), question, now);
        question.setOptions(options);
        questionRepository.save(question);
    }

    private Set<Option> getOptions(List<OptionRequest> optionRequests, Question question, Timestamp now) {
        Set<Option> options = optionRequests
                .stream()
                .map(optionRequest -> createOption(optionRequest, question, now))
                .collect(toSet());
        return options;
    }

    private Option createOption(OptionRequest optionRequest, Question question, Timestamp now) {
        return new Option(randomUUID().toString(), optionRequest.getText(), now, now,
                optionRequest.getCorrectOption(), question);
    }
}
