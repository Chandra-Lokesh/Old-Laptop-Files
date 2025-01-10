package multithreading;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSync {

    Lock lock = new ReentrantLock();

    public synchronized void printScores(String player, List<Integer> scores){
//        synchronized (this){
//            System.out.println("Scores of " + player);
//            scores.forEach(s -> System.out.println(s));
//        }

        lock.lock();

        System.out.println("Scores of " + player);
        scores.forEach(s -> System.out.println(s));

        lock.unlock();
    }

    public static void main(String[] args) {
        List<Integer> sachinScores = List.of(85, 28, 44, 61, 30);
        List<Integer> viratScores = List.of(85, 28, 44, 61, 30);

        ThreadSync ts = new ThreadSync();

        Thread t1 = new Thread(()->ts.printScores("Sachin", sachinScores));
        Thread t2 = new Thread(()->ts.printScores("Virat", viratScores));

        t1.start();
        t2.start();
    }

}
