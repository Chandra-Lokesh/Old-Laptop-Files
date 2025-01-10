package com.ust.repository;

import com.ust.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College, Integer> {
}
