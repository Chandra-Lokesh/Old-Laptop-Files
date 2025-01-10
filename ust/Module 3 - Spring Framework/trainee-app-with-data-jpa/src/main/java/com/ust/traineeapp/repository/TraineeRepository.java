package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
    Trainee findByName(String name);

//    @Query(name = "")
    List<Trainee> findByLocation(String location);

    @Query(value = "select * from trainee_db where Extract(MONTH from joined_date) = :month and Extract(YEAR from joined_date) = :year", nativeQuery = true)
    public List<Trainee> getAllByMonthAndYear(int month, int year);
}
