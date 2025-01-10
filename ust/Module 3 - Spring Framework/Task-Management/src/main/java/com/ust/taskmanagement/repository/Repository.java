package com.ust.taskmanagement.repository;

import com.ust.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Repository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(String status);
    Task findByName(String name);
    @Query("from Task Where dueDate < :current AND status='PENDING'")
    List<Task> findOverdueTasks(LocalDate current);

//    @Query("from Task where taskStatus='Active'")
//    List<Task> findAll();

}
