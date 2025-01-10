package com.ust.webapp.controller;

import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeRestController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trainee getTrainee(@PathVariable("id") int id){
        return traineeService.getTrainee(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Trainee> saveTrainee(@RequestBody Trainee trainee){
        traineeService.addTrainee(trainee);
        return ResponseEntity.status(HttpStatus.CREATED).body(trainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Trainee> deleteTrainee(@PathVariable("id") int id){
        traineeService.deleteTrainee(id);
        return traineeService.getAllTrainees();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trainee updateTrainee(@RequestBody Trainee trainee){
        return traineeService.updateTrainee(trainee);
    }

    @GetMapping("/search")
    public ResponseEntity<Trainee> getByName(@RequestParam("name") String name){
        Trainee trainee = traineeService.getTraineeByName(name);
        if(trainee == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(trainee);
    }

}
