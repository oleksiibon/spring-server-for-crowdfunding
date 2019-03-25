package com.example.crowdfunding.repo;

import com.example.crowdfunding.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, Long> {
}
