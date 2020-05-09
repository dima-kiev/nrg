package com.github.dimakiev.nrg.controllers;

import com.github.dimakiev.nrg.entities.User;
import com.github.dimakiev.nrg.services.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    private UserRepository userRepo;

    @Autowired
    public MainController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(path = "/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(path = "/first_user", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<User> firstUser() {
        return userRepo.findAll().elementAt(0);
    }

    @GetMapping("/")
    @ResponseBody
    public String root() {
        return "33333333";
    }


}
