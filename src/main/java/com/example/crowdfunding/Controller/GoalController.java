package com.example.crowdfunding.Controller;

import com.example.crowdfunding.Domain.Goal;
import com.example.crowdfunding.repo.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goal")
@CrossOrigin
public class GoalController {
    @Autowired
    private final GoalRepo goalRepo;

    public GoalController(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }

    @GetMapping
    public List<Goal> goals() {
        return goalRepo.findAll();
    }

    @PostMapping
    public Goal add(@RequestBody Goal goal){
        return goalRepo.save(goal);
    }
}
