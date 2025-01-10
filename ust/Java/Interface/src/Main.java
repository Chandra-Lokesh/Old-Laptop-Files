package Interface.src;

import Interface.src.CanonPrinter;
import Interface.src.Printable;

public class Main {
    public static void main(String[] args) {
        Printable p = new CanonPrinter();
        CanonPrinter cp = new CanonPrinter();
        p.print();
    }
}
