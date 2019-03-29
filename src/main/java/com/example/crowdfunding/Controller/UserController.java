package com.example.crowdfunding.Controller;

import com.example.crowdfunding.Domain.User;
import com.example.crowdfunding.repo.UserDetailsRepo;
import com.example.crowdfunding.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    final UserDetailsRepo userRepo;

    public UserController(UserDetailsRepo userRepo) {
        this.userRepo = userRepo;
    }

    @JsonView(Views.User.class)
    @GetMapping
    public List<User> getGoals() {
        return userRepo.findAll();
    }

    @JsonView(Views.User.class)
    @GetMapping("{username}")
    public User getUsers(@PathVariable String username) {
        return userRepo.findByUsername(username);
    }
}
