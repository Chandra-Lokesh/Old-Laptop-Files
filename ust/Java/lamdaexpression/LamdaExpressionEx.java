package lamdaexpression;

interface Printer{
    void print(String str);
    static void fun(){
        System.out.println("Have Fun");
    }
}

public class LamdaExpressionEx {
    public static void main(String[] args) {
//        Printer p = new Printer() {
//            @Override
//            public void print() {
//                System.out.println("Printing...");
//            }
//        };
        Printer p = (String str)-> System.out.println("Printing... " + str);
        p.print("Hell Ust");
    }
}
