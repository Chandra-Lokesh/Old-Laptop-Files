package com.ust.repository;

import com.ust.model.Trainee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TraineeRepository extends MongoRepository<Trainee, Integer> {
}
