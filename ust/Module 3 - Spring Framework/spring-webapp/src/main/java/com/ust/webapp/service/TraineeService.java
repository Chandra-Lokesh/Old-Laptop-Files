package com.ust.webapp.service;

import com.ust.webapp.model.Trainee;
import com.ust.webapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {

    @Autowired
    TraineeRepository traineeRepository;

    public void addTrainee(Trainee trainee){
        traineeRepository.saveTrainee(trainee);
    }

    public Trainee getTrainee(int id){
        return traineeRepository.getTrainee(id);
    }

    public List<Trainee> getAllTrainees(){
        return traineeRepository.getTraineeList();
    }

    public void deleteTrainee(int id){
        traineeRepository.deleteTrainee(id);
    }

    public Trainee updateTrainee(Trainee trainee){
        return traineeRepository.updateTrainee(trainee);
    }

    public Trainee getTraineeByName(String name){
        return traineeRepository.getTraineeByName(name);
    }
}
