package com.ust.taskmanagement.repository;

import com.fasterxml.jackson.core.util.ReadConstrainedTextBuffer;
import com.ust.taskmanagement.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {

    List<Task> list = new ArrayList<>();

    @PostConstruct
    void init(){
//        list.add(new Task(1, "name1", "description1", LocalDate.of(2024, 12, 13), "Completed"));
//        list.add(new Task(2, "name2", "description2", LocalDate.of(2022, 12, 20), "Completed"));
    }

    public Task save(Task task){
        list.add(task);
        return task;
    }

    public List<Task> getAll(){
        return list;
    }

    public Optional<Task> getById(int id){
        return list.stream().filter(i -> i.getId() == id).findFirst();
    }

    public void delete(int id){
        list.removeIf(i -> i.getId() == id);
    }

    public Task update(Task task){
        Task oldtask = list.stream().filter(i -> i.getId() == task.getId()).findFirst().orElse(null);
        oldtask.setName(task.getName());
        oldtask.setDescription(task.getDescription());
        oldtask.setStatus(task.getStatus());
        return task;
    }

    public Optional<Task> getByName(String name){
        return list.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public List<Task> getTaskByStatus(String status){
        return list.stream().filter(i -> i.getStatus().equals(status)).toList();
    }


}
