package com.raga.controller;

import com.raga.repository.LevelRepository;
import com.raga.vo.Level;
import com.raga.vo.request.AddLevelRequest;
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
@RequestMapping("/levels")
public class LevelController {
    private LevelRepository repository;

    @Autowired
    public LevelController(LevelRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public Iterable<Level> getLevels() {
        return repository.findAll();
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public void addLevel(@RequestBody AddLevelRequest request) {
        Level level = new Level(randomUUID().toString(), request.getCode(), now());
        repository.save(level);
    }
}
