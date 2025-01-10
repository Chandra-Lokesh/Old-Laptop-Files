package com.ust.traineeapp;

import com.ust.traineeapp.configuration.TraineeAppConfig;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import com.ust.traineeapp.repository.TraineeRepositoryImpl;
import com.ust.traineeapp.service.TraineeService;
import com.ust.traineeapp.service.TraineeServiceImpl;
import com.ust.traineeapp.util.JdbcConnectionUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        TraineeRepository traineeRepository = new TraineeRepositoryImpl();

//        TraineeService traineeService = new TraineeServiceImpl();

        ApplicationContext context = new AnnotationConfigApplicationContext(TraineeAppConfig.class);
//        Trainee trainee = new Trainee(0, "world", "mumbai", LocalDate.of(2004, 02, 19));
//        traineeService.saveTrainee(trainee);
        TraineeService traineeService = context.getBean(TraineeServiceImpl.class);
        traineeService.getAllTrainees().forEach(System.out::println);
//        System.out.println(traineeService.getTraineeById(12));
//        traineeService.deleteTrainee(14);
//        System.out.println("After Deletion ->");
//        traineeService.getAllTrainees().forEach(System.out::println);


    }
}