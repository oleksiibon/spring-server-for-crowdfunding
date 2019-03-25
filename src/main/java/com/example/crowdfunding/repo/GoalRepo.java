package com.example.crowdfunding.repo;

import com.example.crowdfunding.Domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepo extends JpaRepository<Goal, Long> {
}
