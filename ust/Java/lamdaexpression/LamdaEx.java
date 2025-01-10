package lamdaexpression;

interface Printer2{
    void print();
}

public class LamdaEx {
    public static void main(String[] args) {
        Printer2 p = ()-> System.out.println("Printing...");
    }
}
