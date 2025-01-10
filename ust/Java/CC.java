import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class CC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Float> hm = new HashMap<>();
        hm.put("INR", 1f);
        hm.put("USD", 83.76f);
        hm.put("EUR", 92.86f);
        System.out.println("Enter source currency: ");
        String sourceCurr = scan.next();
        System.out.println("Enter destination currency: ");
        String destinationCurr = scan.next();
        System.out.println("Enter amount:");
        float amount = scan.nextFloat();
        float amountInINR = amount * hm.get(sourceCurr);
        System.out.println(amount + " " + sourceCurr + " is equal to ");
        System.out.println(amountInINR/(hm.get(destinationCurr)) + " " + destinationCurr);
    }
}
