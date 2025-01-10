package com.ust.traineeapp.api;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/trainees")
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
        Trainee trainee = traineeService.getTrainee(id);
        if(trainee==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(trainee);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee updateTrainee(@RequestBody Trainee trainee){
        return traineeService.updateTrainee(trainee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteTrainee(@PathVariable("id") int id){
        traineeService.deleteTrainee(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee getTraineeByName(@PathVariable("name") String name){
        return traineeService.getTraineeByName(name).orElse(null);
    }

    @GetMapping("/location/{location}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainee> getTraineeByLocation(@PathVariable("location") String location){
        return traineeService.getTraineeByLocation(location);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<Trainee> findTraineeByMonthAndYear(@PathVariable("month") int month,@PathVariable("year") int year){

        return traineeService.findTraineeByMonthAndYear(month, year);
    }
}
