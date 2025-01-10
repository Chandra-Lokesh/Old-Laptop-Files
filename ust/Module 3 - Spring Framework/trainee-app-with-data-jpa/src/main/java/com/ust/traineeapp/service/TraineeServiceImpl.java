package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.RecordAlreadyExists;
import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.ProjectRepository;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        if(traineeRepository.existsById(trainee.getId())){
            throw new RecordAlreadyExists("Trainee with Id " + trainee.getId() + " already Exists!");
        }
//        Project project = trainee.getProject();
//        projectRepository.save(project);
//        Trainee savedTrainee = traineeRepository.save(trainee); // upsert
//        Project project = savedTrainee.getProject();
//        project.setTrainee(savedTrainee);
//        projectRepository.save(project);
//        savedTrainee.setProject(project);
//        Project project = savedTrainee.getProject();

//        Project project = projectRepository.findById(trainee.getProject().getId()).orElse(null);
        Trainee savedTrainee;
//        if (project != null) {
//            trainee.setProject(project);
//            savedTrainee = traineeRepository.save(trainee);
//            project.getTrainees().add(savedTrainee);
//            projectRepository.save(project);
//        }
//        else {
//            savedTrainee = traineeRepository.save(trainee);
//        }

        savedTrainee = traineeRepository.save(trainee);

        return savedTrainee;
    }

    @Override
    public Trainee getTrainee(int id) {
        return traineeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Trainee with id " + id + " Not Found!"));
    }

    @Override
    public void deleteTrainee(int id) {
        traineeRepository.deleteById(id);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainee updateTrainee(Trainee trainee) {
        if(trainee.getName()!=null && trainee.getLocation()!=null && trainee.getJoinedDate()!=null){
            return traineeRepository.save(trainee);
        }
        throw new RuntimeException("Property of Trainee should not be null!");
    }

    @Override
    public Optional<Trainee> getTraineeByName(String name) {
        return Optional.of(traineeRepository.findByName(name));
    }

    public List<Trainee> getTraineeByLocation(String location) {
        return traineeRepository.findByLocation(location);
    }

    public List<Trainee> findTraineeByMonthAndYear(int month, int year){
        return traineeRepository.getAllByMonthAndYear(month, year);
    }

}
