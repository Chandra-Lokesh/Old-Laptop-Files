package com.ust.repository;

import com.ust.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Employee, Integer> {

}
