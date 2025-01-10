package multithreading;

public class Downlaoder extends Thread{
    @Override
    public void run() {
        try {
            this.download();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void download() throws InterruptedException{
        for (int i = 0; i <= 100; i+=10) {
            System.out.println(this.getName() + " Downloading: " + i + "%");
            Thread.sleep(1000);
        }
        System.out.println("Download Complete...");
    }
}
