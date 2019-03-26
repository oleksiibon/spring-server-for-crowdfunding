package com.example.crowdfunding.repo;

import com.example.crowdfunding.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
