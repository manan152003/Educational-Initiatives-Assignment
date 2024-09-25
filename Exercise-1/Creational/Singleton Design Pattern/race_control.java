class RaceControlSingleton {
    private static RaceControlSingleton instance = new RaceControlSingleton();

    private RaceControlSingleton() {}

    public static RaceControlSingleton getInstance() {
        return instance;
    }

    public void displayControlMessage(String message) {
        System.out.println("Race Control Message: " + message);
    }
}

public class race_control {
    public static void main(String args[]) {
        RaceControlSingleton control1 = RaceControlSingleton.getInstance();
        control1.displayControlMessage("Safety Car Deployed");

        RaceControlSingleton control2 = RaceControlSingleton.getInstance();
        control2.displayControlMessage("Checkered Flag -> Race Ends!");
    }
}
