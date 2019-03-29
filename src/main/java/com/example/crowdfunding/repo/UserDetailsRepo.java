package com.example.crowdfunding.repo;

import com.example.crowdfunding.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
