class SafetyCar {
    public void startSafetyCar() {
        System.out.println("Depolyed Safety Car for outlap");
    }
}

class Lights {
    public void startLights() {
        System.out.println("Lights on");
    }
}
class Grid{
    public void checkGrid(){
        System.out.println("All cars on the grid positions");
    }
}
class Race {
    public void startRace() {
        System.out.println("Race starting 3... 2... 1...");
        System.out.println("LIGHTS OUT & AWAY WE GO!");
    }
}

class RaceWeekendFacade {
    private SafetyCar safetycar;
    private Lights lights;
    private Grid grid;
    private Race race;

    public RaceWeekendFacade() {
        this.safetycar = new SafetyCar();
        this.lights = new Lights();
        this.grid = new Grid();
        this.race = new Race();
    }

    public void startRaceWeekend() {
        safetycar.startSafetyCar();
        lights.startLights();
        grid.checkGrid();
        race.startRace();
    }
}

public class race_weeknd {
    public static void main(String args[]) {
        RaceWeekendFacade raceWeekend = new RaceWeekendFacade();
        raceWeekend.startRaceWeekend();
    }
}
