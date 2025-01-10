package multithreading.com.ust.paytm;

public class PaytmOperation extends Thread{

    public static void main(String[] args) throws InterruptedException {

        PaytmWallet pw = new PaytmWallet(100);
//        pw.payBill(200);

        Thread payBillThread = new Thread(() -> pw.payBill(150));
        Thread addMoneyThread = new Thread(() -> pw.addMoney(100.0));

        payBillThread.start();
        addMoneyThread.start();

//        payBillThread.join();
//        addMoneyThread.join();

    }

}

class PaytmWallet extends Thread{

    private double balance;

    public PaytmWallet(double balance) {
        this.balance = balance;
    }

    synchronized void addMoney(double amount){
        System.out.println(amount + " Rupees is being added into wallet...");
        this.balance += amount;
        System.out.println("Current Balance: " + balance);
        notifyAll();
    }

    synchronized void payBill(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
        }
        else{
            System.out.println("Your Balance is Low!, Extra amount is being added!");
            try {
//                this.addMoney(amount - balance);
                wait();
                System.out.println("Transaction Successful...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
