package multithreading;

public class DownlaoderWithRunnable implements Runnable{

    @Override
    public void run() {
        this.download();
    }
    public void  download(){
        for (int i = 0; i <= 100; i+=10) {
            System.out.println("Downloading" + Thread.currentThread().getName());
            if(Thread.currentThread().getName().equalsIgnoreCase("downloader1")){
//                Thread.yield();
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//            System.out.println(Thread.currentThread().getName() + " Downloading: " + i + "%");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        System.out.println("Download Complete...");

    }
}
