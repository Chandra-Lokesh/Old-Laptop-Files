import java.util.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter!");
        while(true){
            System.out.println("Supported currencies:\n" +
                    "1. USD (US Dollar)\n" +
                    "2. EUR (Euro)\n" +
                    "3. GBP (British Pound)\n" +
                    "4. JPY (Japanese Yen)\n" +
                    "5. Exit");
            System.out.println("Select Currency: ");
            int opt = scan.nextInt();
            System.out.println("Enter Amount: ");
            int amount = scan.nextInt();
            if(opt == 5)
                return;
            switch (opt){
                case 1 -> System.out.println(amount + " USD is equal to " + (amount * 83.76) + " INR");
                case 2 -> System.out.println(amount + " EUR is equal to " + (amount * 92.86) + " INR");
                case 3 -> System.out.println(amount + " GBP is equal to " + (amount * 108.90) + " INR");
                case 4 -> System.out.println(amount + " JPY is equal to " + (amount * 0.57) + " INR");
                default -> System.out.println("Select a valid Option!");
            }
        }
    }
}
