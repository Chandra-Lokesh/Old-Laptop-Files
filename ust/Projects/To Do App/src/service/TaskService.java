package service;

import model.Status;
import model.Task;
import repository.TaskRepository;

import java.util.Queue;
import java.util.Stack;

public class TaskService {

    TaskRepository taskRepository = new TaskRepository();

    public void displayAllPendingTasks(){
        Queue<Task> pendingTasks = taskRepository.getAllPendingTasks();
        System.out.println("---- Pending Tasks ----");
        for(Task t: pendingTasks){
            System.out.print("[\n\tTitle: " + t.getTitle()+
                    "\n\tPriority: " + t.getPriority()+
                    "\n\tStatus: " + t.getStatus()+
                    "\n]\n");
        }
    }
    public void displayAllCompletedTasks(){
        Stack<Task> completedTasks = taskRepository.getAllCompletedTasks();
        System.out.println("---- Completed Tasks ----");
        for(Task t: completedTasks){
            System.out.print("[\n\tTitle: " + t.getTitle()+
                    "\n\tPriority: " + t.getPriority()+
                    "\n\tStatus: " + t.getStatus()+
                    "\n]\n");
        }
    }
    public void addTask(String title, int priority){
        Task t = new Task(title, priority);
        t.setStatus(Status.Pending);
        taskRepository.addTask(t);
    }
    public void finishTask(String title){
        taskRepository.markComplete(title);
    }

}
