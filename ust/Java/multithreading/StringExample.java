package multithreading;

public class StringExample {
    public static void main(String[] args){
        Runnable runnable = new DownlaoderWithRunnable();

//        Thread d1 = new Downlaoder();
//        Thread d2 = new Downlaoder();

        Downlaoder task = new Downlaoder();

//        Thread d1 = new Thread(runnable);
//        Thread d2 = new Thread(runnable);

        Thread d1 = new Thread(()-> {
            try {
                task.download();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread d2 = new Thread(()-> {
            try {
                task.download();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        d1.setName("Downlaoder 1");
        d2.setName("Downlaoder 2");

//        d2.setPriority(Thread.MAX_PRIORITY);
//        d1.setPriority(Thread.MIN_PRIORITY);

        d1.start();
        d2.start();
    }
}
