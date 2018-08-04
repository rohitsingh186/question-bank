package com.raga.controller;

import com.raga.repository.UserRepository;
import com.raga.vo.User;
import com.raga.vo.request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/users")
public class UserController {
    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public Iterable<User> getUsers() {
        return repository.findAll();
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public void addUser(@RequestBody AddUserRequest request) {
        User user = new User(randomUUID().toString(), request.getUserName(), request.getFullName());
        repository.save(user);
    }
}
