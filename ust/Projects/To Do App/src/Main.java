import model.Status;
import service.TaskService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskService taskService = new TaskService();

        taskService.addTask("task1", 5);
        taskService.addTask("task2", 4);
        taskService.addTask("task3", 3);
        taskService.addTask("task4", 2);
        taskService.addTask("task5", 1);



        while(true){
            System.out.println("Select and Option:\n1. Add Task\n2. Finish a Task\n" +
                    "3. Display Tasks\n4. Display Completed Tasks\n5. Exit");

            System.out.println("Enter your Choice:");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
//                    System.out.println("Enter title:");
//                    String title = sc.next();
//                    System.out.println("Enter priority:");
//                    int priority = sc.nextInt();
//                    taskService.addTask(title, priority);
                    break;
                case 2:
                    System.out.println("Enter finished task title: ");
                    String title = sc.next();
                    taskService.finishTask(title);
                    break;
                case 3:
                    taskService.displayAllPendingTasks();
                    break;
                case 4:
                    taskService.displayAllCompletedTasks();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choice Invalid!");
            }
        }

    }
}