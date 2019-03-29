package com.example.crowdfunding.Controller;

import com.example.crowdfunding.DTO.DonationDTO;
import com.example.crowdfunding.Domain.Donation;
import com.example.crowdfunding.Domain.Goal;
import com.example.crowdfunding.Domain.User;
import com.example.crowdfunding.repo.DonationRepo;
import com.example.crowdfunding.repo.GoalRepo;
import com.example.crowdfunding.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Object add(@RequestBody DonationDTO donation) {
        User user = userRepo.findByUsername(donation.userId);
        Goal goal = goalRepo.findById(donation.goalId).orElse(null);
        if (user.getBalance() >= donation.amount) {
            user.setBalance(user.getBalance() - donation.amount);
            userRepo.save(user);
            Donation donationForSave = new Donation(donation.date, user, goal, donation.amount);
            return donationRepo.save(donationForSave);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You do not have money");
    }
}
