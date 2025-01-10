package com.ust.service;

import com.ust.model.Trainee;
import com.ust.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    TraineeRepository traineeRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Trainee saveTrainee(Trainee trainee) {
        if(traineeRepository.existsById(trainee.getId())){
            throw new RuntimeException("trainee already exists!");
        }
        return traineeRepository.save(trainee);
    }


    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainee getTraineeById(int id) {
        if(!traineeRepository.existsById(id))
            throw new RuntimeException("trainee not found!");
        return traineeRepository.findById(id).orElse(null);
    }

    @Override
    public void removeTrainee(int id) {
        if(!traineeRepository.existsById(id))
            throw new RuntimeException("trainee not found!");
        traineeRepository.deleteById(id);
    }

    @Override
    public Trainee updateTrainee(int id, Trainee trainee) {
        if(!traineeRepository.existsById(id))
            throw new RuntimeException("trainee not found!");
        return traineeRepository.save(trainee);
    }
}
