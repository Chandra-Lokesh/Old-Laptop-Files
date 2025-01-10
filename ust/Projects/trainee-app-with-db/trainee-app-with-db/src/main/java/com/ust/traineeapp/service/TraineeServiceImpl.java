package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import com.ust.traineeapp.repository.TraineeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    TraineeRepository traineeRepository;

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    @Override
    public Optional<Trainee> getTraineeById(int id) {
        Optional<Trainee> trainee = traineeRepository.getTrainee(id);
        if(trainee.isEmpty())
            System.out.println("Trainee not found!");
        return trainee;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        List<Trainee> trainees = traineeRepository.getAllTrainees();
        if(trainees.isEmpty()){
            System.out.println("No Trainees found!");
        }
        return trainees;
    }

    @Override
    public void deleteTrainee(int id) {
        traineeRepository.deleteTrainee(id);
    }
}