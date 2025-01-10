import java.util.*;

//Read a number from user
// Number between 1-100 (don't count that attempt)
//show hints like please go backward/forward
//if 50% attempts are over
//if 50% of the attempts are over and you are still far away then show the random no. 5_

public class RandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Mysterious Number Guesser!");
        int randomNumber = (int)(Math.random() * 100);
        System.out.println(randomNumber);
//        Random random = new Random(100);
//        randomNumber = random.nextInt(100) + 1;
        System.out.println("I have select a number between 1 and 100, Can you guess it?");
        int totalAttempts = 6;
        int attemptsLeft = totalAttempts;
        while(attemptsLeft-- > 0){
            System.out.println("Enter your Guess: ");
            String userInput = sc.next();
            int userNumber;
            try{
                userNumber = Integer.parseInt(userInput);
            }
            catch (Exception e){
                System.out.println("Error: Please enter a valid integer.");
                continue;
            }
            int guessDiff = Math.abs(userNumber-randomNumber);
            if(guessDiff == 0){
                System.out.println("Congratulations! You've guessed the number!");
                return;
            }
            else if(guessDiff <= 10){
                System.out.println("You're Getting Close!");
                if(attemptsLeft < (int)(totalAttempts/2)){
                    System.out.println("Hint: ");
                    if(userNumber - randomNumber > 0)
                        System.out.println("Move Backward!");
                    else
                        System.out.println("Move Forward!");
                }
            }
            else{
                System.out.println("You're far away!");
                if(attemptsLeft < (int)(totalAttempts/2)){
                    System.out.println("Hint: ");
                    System.out.println(getFirstDigit(randomNumber)+"x");
                }
            }
        }
        System.out.println("Oops! You Lost, Restart the Game.");
    }

    public static int getFirstDigit(int number){
        int ans=0;
        if(number < 10)
            return 0;
//        if(number == 100)
//            return
        while(number != 0){
            ans = number % 10;
            number = number / 10;
        }
        return ans;
    }
}
