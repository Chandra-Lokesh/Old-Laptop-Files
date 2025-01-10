package repository;

import model.Status;
import model.Task;

import java.util.*;

public class TaskRepository {

    private Queue<Task> pendingTasks = new PriorityQueue<>(new PriorityComparator());
    private Stack<Task> completedTasks = new Stack<>();

    public Queue<Task> getAllPendingTasks(){
        return pendingTasks;
    }

    public Stack<Task> getAllCompletedTasks(){
        return completedTasks;
    }

    public void addTask(Task task){
        pendingTasks.offer(task);
    }

    public void markComplete(String title){
        for(Task t: pendingTasks){
            if(t.getTitle().equals(title)){
                t.setStatus(Status.Completed);
                pendingTasks.remove(t);
                completedTasks.push(t);
                break;
            }
        }
    }
}
