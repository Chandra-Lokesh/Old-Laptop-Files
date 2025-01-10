package SimExample;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Sim airtelSim = new AirtelSim();
        Sim jioSim = new JioSim();

        phone.setSim(airtelSim);
        phone.call();
    }
}