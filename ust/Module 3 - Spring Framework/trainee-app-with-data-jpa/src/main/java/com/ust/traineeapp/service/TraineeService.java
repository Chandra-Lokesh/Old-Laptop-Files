package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeService {

    Trainee saveTrainee(Trainee trainee);
    Trainee getTrainee(int id);
    void deleteTrainee(int id);
    List<Trainee> getAllTrainees();
    Trainee updateTrainee(Trainee trainee);
    Optional<Trainee> getTraineeByName(String name);
    List<Trainee> getTraineeByLocation(String location);
    List<Trainee> findTraineeByMonthAndYear(int month, int year);
}
