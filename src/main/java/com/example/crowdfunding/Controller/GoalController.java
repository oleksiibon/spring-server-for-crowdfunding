package com.example.crowdfunding.Controller;

import com.example.crowdfunding.Domain.Goal;
import com.example.crowdfunding.Domain.GoalDTO;
import com.example.crowdfunding.Domain.User;
import com.example.crowdfunding.repo.GoalRepo;
import com.example.crowdfunding.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/goal")
@CrossOrigin
public class GoalController {
    @Autowired
    private final GoalRepo goalRepo;
    @Autowired
    private final UserDetailsRepo userRepo;

    public GoalController(GoalRepo goalRepo, UserDetailsRepo userRepo) {
        this.goalRepo = goalRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<Goal> goals() {
        return goalRepo.findAll();
    }

    @PostMapping
    public Goal add(@RequestBody GoalDTO goal){
        User user = userRepo.findById(goal.creatorId).orElse(null);
        Goal goalForSave = new Goal(goal.name, goal.picture, goal.cost, user);
        return goalRepo.save(goalForSave);
    }
}
