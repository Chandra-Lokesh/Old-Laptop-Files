package exception_handling;

public class One {
    public static void main(String[] args) {
        System.out.println("Hello ...");
        System.out.println("We are doing math operations...");
        int a = 10, b = 0;

        System.out.println("Division...");
        try{
            int div = a / b;
            System.out.println("Result:" + div);
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.err.println("Divided by Zero");
        }

        System.out.println("Multiplication...");
        int mul = a * b;
        System.out.println("Result:" + mul);

        System.out.println("Bye...");
    }
}
