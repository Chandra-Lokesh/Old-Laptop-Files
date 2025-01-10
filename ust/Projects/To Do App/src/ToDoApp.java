import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToDoApp {

    private Queue<String> taskQueue = new LinkedList<>();
    private Stack<String> completedTasks = new Stack<>();

    public void addTask(){
        taskQueue.offer("Learn Java");
        taskQueue.offer("Learn Swimming");
        taskQueue.offer("Learn Dancing");
        taskQueue.offer("Learn Python");
    }

    public void processTasks(){
        while(!taskQueue.isEmpty()){
            String currentTask = taskQueue.poll();
            System.out.println(currentTask);
            System.out.println(currentTask + " Completed!");
            completedTasks.push(currentTask);
        }
    }

    public void displayCompletedTasks(){
        for(String t: completedTasks){
            System.out.print(t + " ");
        }
    }
}
