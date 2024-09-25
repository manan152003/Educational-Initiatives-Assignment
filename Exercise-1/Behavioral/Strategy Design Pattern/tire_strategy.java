interface TireStrategy {
    String chooseTires();
}

class SoftTireStrategy implements TireStrategy {
    public String chooseTires() {
        return "Soft tires for dry conditions & highest speed";
    }
}

class HardTireStrategy implements TireStrategy {
    public String chooseTires() {
        return "Hard tires for dry conditions & highest edurance";
    }
}


class WetTireStrategy implements TireStrategy {
    public String chooseTires() {
        return "Wet tires for rainy conditions";
    }
}

class Team {
    private TireStrategy tireStrategy;

    public void setTireStrategy(TireStrategy tireStrategy) {
        this.tireStrategy = tireStrategy;
    }

    public void executeStrategy() {
        System.out.println(tireStrategy.chooseTires());
    }
}

public class tire_strategy{
    public static void main(String args[]){
        Team ferrari = new Team();

        TireStrategy softTireStrategy = new SoftTireStrategy(); //Scene-1
        ferrari.setTireStrategy(softTireStrategy);
        System.out.print("Lap 2:\nTrack Condition: Dry track -> ");
        ferrari.executeStrategy();

        TireStrategy hardTireStrategy = new HardTireStrategy();
        ferrari.setTireStrategy(hardTireStrategy);
        System.out.print("Lap 8:\nTrack Condition: Long race on dry track -> ");
        ferrari.executeStrategy();


        TireStrategy wetTireStrategy = new WetTireStrategy();
        ferrari.setTireStrategy(wetTireStrategy);
        System.out.print("Lap 16:\nTrack Condition: Rainy track -> ");
        ferrari.executeStrategy();
    }
}