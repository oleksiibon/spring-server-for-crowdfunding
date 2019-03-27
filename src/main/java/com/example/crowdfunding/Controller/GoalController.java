package com.example.crowdfunding.Controller;

import com.example.crowdfunding.Domain.Category;
import com.example.crowdfunding.Domain.Goal;
import com.example.crowdfunding.DTO.GoalDTO;
import com.example.crowdfunding.Domain.User;
import com.example.crowdfunding.repo.CategoryRepo;
import com.example.crowdfunding.repo.GoalRepo;
import com.example.crowdfunding.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goal")
@CrossOrigin
public class GoalController {
    @Autowired
    private final GoalRepo goalRepo;
    @Autowired
    private final UserDetailsRepo userRepo;
    @Autowired
    private final CategoryRepo categoryRepo;
    public GoalController(GoalRepo goalRepo, UserDetailsRepo userRepo, CategoryRepo categoryRepo) {
        this.goalRepo = goalRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<Goal> goals() {
        return goalRepo.findAll();
    }

    @GetMapping("{id}")
    public Goal goal(@PathVariable("id") Goal goal) {
        return goal;
    }


    @PostMapping
    public Goal add(@RequestBody GoalDTO goal){
        User user = userRepo.findById(goal.creatorId).orElse(null);
        Category category = categoryRepo.findById(goal.categoryId).orElse(null);
        Goal goalForSave = new Goal(goal.name, goal.picture, goal.cost, user, category, goal.description);
        return goalRepo.save(goalForSave);
    }
}
