package com.example.crowdfunding.Controller;

import com.example.crowdfunding.DTO.DonationDTO;
import com.example.crowdfunding.Domain.Donation;
import com.example.crowdfunding.Domain.Goal;
import com.example.crowdfunding.Domain.User;
import com.example.crowdfunding.repo.DonationRepo;
import com.example.crowdfunding.repo.GoalRepo;
import com.example.crowdfunding.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/donation")
@CrossOrigin
public class DonationController {
    @Autowired
    private DonationRepo donationRepo;
    @Autowired
    private GoalRepo goalRepo;
    @Autowired
    private UserDetailsRepo userRepo;

    public DonationController() {
    }

    @PostMapping()
    public Donation add(@RequestBody DonationDTO donation) {
        User user = userRepo.findById(donation.userId).orElse(null);
        Goal goal = goalRepo.findById(donation.goalId).orElse(null);
        Donation donationForSave = new Donation(donation.date, user, goal, donation.amount);
        return donationRepo.save(donationForSave);
    }
}
