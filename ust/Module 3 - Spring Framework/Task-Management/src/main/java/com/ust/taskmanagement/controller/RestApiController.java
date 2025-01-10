package com.ust.taskmanagement.controller;

import com.ust.taskmanagement.exception.NullException;
import com.ust.taskmanagement.exception.TaskNotFoundException;
import com.ust.taskmanagement.model.Task;
import com.ust.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/tasks")
public class RestApiController {

    @Autowired
    TaskService taskService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAll(){
        return taskService.getAllActiveTasks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Task addTask(@RequestBody Task task) throws NullException {
        return taskService.saveTask(task);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskById(@PathVariable("id") int id) throws TaskNotFoundException {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable("id") int id){
        taskService.deleteTask(id);
    }

    @DeleteMapping("/soft-delete/{id}")
    public void softDelete(@PathVariable("id") int id){
        taskService.softDeleteTask(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTaskByStatus(@PathVariable("status") String status){
        return taskService.getTaskByStatus(status);
    }

    @GetMapping("/overdue")
    public List<Task> getOverDueTask(){
        return taskService.getOverDueTasks(LocalDate.now());
    }

    @GetMapping("/sort")
    public List<Task> getSortedTasks(){
        return taskService.getSortedTasks();
    }

    @GetMapping("/inactive")
    public List<Task>getInactiveTasks(){
        return taskService.getAllInActiveTasks();
    }

    @GetMapping("/name/{name}")
    public Task getTaskByName(@PathVariable("name") String name){
        return taskService.getTaskByName(name);
    }

}
