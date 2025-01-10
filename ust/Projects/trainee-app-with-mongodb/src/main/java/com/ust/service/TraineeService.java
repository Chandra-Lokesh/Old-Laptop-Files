package com.ust.service;

import com.ust.model.Trainee;

import java.util.List;

public interface TraineeService {
    Trainee saveTrainee(Trainee trainee);
    List<Trainee> getAllTrainees();
    Trainee getTraineeById(int id);
    void removeTrainee(int id);
    Trainee updateTrainee(int id, Trainee trainee);
}
