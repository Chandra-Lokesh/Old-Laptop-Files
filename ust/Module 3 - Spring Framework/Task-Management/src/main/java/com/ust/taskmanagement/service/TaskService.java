package com.ust.taskmanagement.service;

import com.ust.taskmanagement.exception.NullException;
import com.ust.taskmanagement.exception.TaskNotFoundException;
import com.ust.taskmanagement.model.Task;
import com.ust.taskmanagement.repository.Repository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    Repository taskRepository;

    public Task saveTask(Task task) throws NullException {
        if(task.getName().equals("") || task.getName() == null){
            throw new NullException("Name can't be null");
        }

        if(task.getDescription().equals("") || task.getDescription() == null){
            throw new NullException("Description can't be null");
        }

        if(task.getDueDate().equals("") || task.getDueDate() == null){
            throw new NullException("Due Date can't be null");
        }

        if(task.getStatus().equals("") || task.getStatus() == null){
            throw new NullException("Status can't be null");
        }

        if(task.getTaskStatus().equals("") || task.getTaskStatus() == null){
            throw new NullException("Task Status can't be null");
        }

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll().stream().toList();
    }

    public Task getTaskById(int id) throws TaskNotFoundException {

        Task task =  getActiveTaskById(id);
        if(task == null)
            throw new TaskNotFoundException("Task with id: " + id + " not found");
        return task;
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public void softDeleteTask(int id){
        Task task = taskRepository.findById(id).orElse(null);
        if(task !=null){
            task.setTaskStatus("InActive");
            taskRepository.save(task);
        }
    }

    public Task getTaskByName(String name){
        return taskRepository.findByName(name);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getTaskByStatus(String status){
        return taskRepository.findByStatus(status);
    }

    public List<Task> getOverDueTasks(LocalDate current){
        return taskRepository.findOverdueTasks(current);
    }

    public List<Task> getSortedTasks(){
        List<Task> unSortedList = getAllActiveTasks();
        return unSortedList.stream().sorted(Comparator.comparing(i -> i.getDueDate())).toList();
    }

    public List<Task> getAllActiveTasks(){
        List<Task> totalTaskList = taskRepository.findAll().stream().toList();
        return totalTaskList.stream().filter(t -> t.getTaskStatus().equals("Active")).toList();
    }

    public Task getActiveTaskById(int id){
        List<Task> totalActiveTaskList = getAllActiveTasks();
        return totalActiveTaskList.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public List<Task> getAllInActiveTasks(){
        List<Task> totalTaskList = taskRepository.findAll().stream().toList();
        return totalTaskList.stream().filter(t -> t.getTaskStatus().equals("InActive")).toList();
    }

}
