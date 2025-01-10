package com.ust.controller;

import com.ust.model.Trainee;
import com.ust.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Trainee saveTrainee(@RequestBody Trainee trainee){
        return traineeService.saveTrainee(trainee);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable("id") int id){
        Trainee trainee = traineeService.getTraineeById(id);
        if(trainee==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(trainee);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee updateTrainee(@PathVariable("id") int id, @RequestBody Trainee trainee){
        return traineeService.updateTrainee(id, trainee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteTrainee(@PathVariable("id") int id){
        traineeService.removeTrainee(id);
    }
}
