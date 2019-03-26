package com.example.crowdfunding.repo;

import com.example.crowdfunding.Domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation, Long> {

}
