package com.example.crowdfunding.Controller;

import com.example.crowdfunding.Domain.User;
import com.example.crowdfunding.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<User> getGoals() {
        List<User> users = userRepo.findAll();
        users.stream().forEach(user -> user.getD);
    }
}
