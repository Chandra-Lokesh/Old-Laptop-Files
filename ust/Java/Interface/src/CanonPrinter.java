package Interface.src;

public class CanonPrinter implements Printable, Scannable{

    @Override
    public void print() {
        System.out.println("Hello from Canon printer!");
    }

    @Override
    public void scan() {
        System.out.println("Scanning.. from Canon Printer!");
    }
}
