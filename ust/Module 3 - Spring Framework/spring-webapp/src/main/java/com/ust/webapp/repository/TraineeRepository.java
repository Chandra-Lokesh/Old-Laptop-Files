package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TraineeRepository {

    List<Trainee> traineeList;

    @PostConstruct
    void init(){
        traineeList = new ArrayList<>();
        Trainee t1 = new Trainee(1, "harsh", "banglore");
        Trainee t2 = new Trainee(2, "karan", "Hyderabad");
        Trainee t3 = new Trainee(3, "karan", "Hyderabad");
        traineeList.add(t1);
        traineeList.add(t2);
        traineeList.add(t3);
    }

    public void saveTrainee(Trainee trainee){
        traineeList.add(trainee);
    }

    public Trainee getTrainee(int id){
        return traineeList.stream().filter(i->i.id()==id).findFirst().orElse(null);
    }

    public List<Trainee> getTraineeList(){
        return traineeList;
    }

    public void deleteTrainee(int id){
        traineeList.removeIf(i -> i.id() == id);
    }

    public Trainee updateTrainee(Trainee trainee){
        traineeList.removeIf(i -> i.id() == trainee.id());
        traineeList.add(trainee);
        return trainee;
    }

    public Trainee getTraineeByName(String name){
        return traineeList.stream().filter(i -> i.name().equals(name)).findFirst().orElse(null);
    }
}
