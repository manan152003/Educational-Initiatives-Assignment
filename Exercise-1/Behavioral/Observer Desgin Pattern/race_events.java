import java.util.*;


interface Observer {
    void update(String event);
}


interface RaceEventSubject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event);
}

class Team implements Observer {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public void update(String event) {
        System.out.println("Team " + name + " received update: " + event);
    }
}


class RaceControl implements RaceEventSubject {
    private List<Observer> teams = new ArrayList<>();

    public void addObserver(Observer observer) {
        teams.add(observer);
    }

    public void removeObserver(Observer observer) {
        teams.remove(observer);
    }

    public void notifyObservers(String event) {
        for (Observer team : teams) {
            team.update(event);
        }
    }

    public void raiseYellowFlag() {
        notifyObservers("Yellow flag raised: Caution on track!");
    }

    public void raiseRedFlag() {
        notifyObservers("Red flag raised: Race halted!");
    }
}

public class race_events{

    public static void main(String args[]) {

        RaceControl raceControl = new RaceControl();


        Team ferrari = new Team("Ferrari");
        Team mercedes = new Team("Mercedes");
        Team redBull = new Team("Red Bull");


        raceControl.addObserver(ferrari);
        raceControl.addObserver(mercedes);
        raceControl.addObserver(redBull);

        System.out.println("\n=== Race Event: Yellow Flag ===");
        raceControl.raiseYellowFlag();

        System.out.println("\n=== Race Event: Red Flag ===");
        raceControl.raiseRedFlag();
    }
}
