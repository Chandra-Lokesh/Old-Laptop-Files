package stackandqueue;

import java.util.*;

public class StackExampl {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(23);
        stack.push(20);
        stack.push(30);

        // stack.pop() = stack.remove(stack.peek())
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            System.out.println(stack.remove(stack.peek()));
        }

//        Queue<String> queue = new LinkedList<>();
//        Queue<String> queue = new ArrayDeque<>();
        Queue<String> queue = new PriorityQueue<>(); // Sorted

        queue.offer("Javed");
        queue.offer("rohan");
        queue.offer("Harsh");
        queue.offer("Taniva");

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
