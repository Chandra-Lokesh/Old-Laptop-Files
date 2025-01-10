package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeService {
    Trainee saveTrainee(Trainee trainee);
    Optional<Trainee> getTraineeById(int id);
    List<Trainee> getAllTrainees();
    void deleteTrainee(int id);
}
