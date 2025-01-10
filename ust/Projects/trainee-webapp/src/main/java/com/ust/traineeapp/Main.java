package com.ust.traineeapp;

import com.ust.traineeapp.service.TraineeService;
import com.ust.traineeapp.service.TraineeServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        TraineeRepository traineeRepository = new TraineeRepositoryImpl();

        TraineeService traineeService = new TraineeServiceImpl();

//        Trainee trainee = new Trainee(0, "world", "mumbai", LocalDate.of(2004, 02, 19));
//        traineeRepository.save(trainee);

//        traineeService.getAllTrainees().forEach(System.out::println);
//        System.out.println(traineeService.getTraineeById(12));
        traineeService.deleteTrainee(14);
        System.out.println("After Deletion ->");
//        traineeService.getAllTrainees().forEach(System.out::println);


    }
}