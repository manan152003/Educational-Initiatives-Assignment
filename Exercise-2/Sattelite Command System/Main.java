import java.util.*;

interface Command {
    void execute(Satellite satellite);
}

class RotateCommand implements Command {
    private final Direction direction;

    public RotateCommand(Direction direction) {
        this.direction = direction;
    }

   
    public void execute(Satellite satellite) {
        satellite.rotate(direction);
    }
}

class ActivatePanelsCommand implements Command {
    public void execute(Satellite satellite) {
        satellite.activatePanels();
    }
}

class DeactivatePanelsCommand implements Command {
    public void execute(Satellite satellite) {
        satellite.deactivatePanels();
    }
}

class CollectDataCommand implements Command {
    public void execute(Satellite satellite) {
        satellite.collectData();
    }
}

class SatelliteCommandSystem {
    private static SatelliteCommandSystem instance = new SatelliteCommandSystem();

    private SatelliteCommandSystem() {}

    public static synchronized SatelliteCommandSystem getInstance() {
        return instance;
    }

    public void executeCommand(Command command, Satellite satellite) {
        command.execute(satellite);
    }
}

class CommandFactory {
    public static Command createCommand(String commandType, Direction direction) {
        switch (commandType.toLowerCase()) {
            case "rotate":
                return new RotateCommand(direction);
            case "activatepanels":
                return new ActivatePanelsCommand();
            case "deactivatepanels":
                return new DeactivatePanelsCommand();
            case "collectdata":
                return new CollectDataCommand();
            default:
                throw new IllegalArgumentException("Invalid command type: " + commandType);
        }
    }
}

enum Direction {
    NORTH, SOUTH, EAST, WEST
}

class Satellite {
    private Direction orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    public Satellite() {
        orientation = Direction.NORTH;
        solarPanelsActive = false;
        dataCollected = 0;
    }

    public void rotate(Direction direction) {
        orientation = direction;
        System.out.println("Satellite rotated to face " + orientation);
    }

    public void activatePanels() {
        solarPanelsActive = true;
        System.out.println("Solar panels activated");
    }

    public void deactivatePanels() {
        solarPanelsActive = false;
        System.out.println("Solar panels deactivated");
    }

    public void collectData() {
        if (solarPanelsActive) {
            dataCollected += 10;
            System.out.println("Data collected. Total data: " + dataCollected);
        } else {
            System.out.println("Cannot collect data. Solar panels are inactive.");
        }
    }

    public void printStatus() {
        System.out.println("Orientation: " + orientation);
        System.out.println("Solar Panels: " + (solarPanelsActive ? "Active" : "Inactive"));
        System.out.println("Data Collected: " + dataCollected);
    }
}

public class Main {
    public static void main(String args[]) {
        Satellite satellite = new Satellite();
        SatelliteCommandSystem commandSystem = SatelliteCommandSystem.getInstance();

        System.out.println("=== Initial Satellite State ===");
        satellite.printStatus();

        // Execute a series of commands
        List<Command> commands = new ArrayList<>();
        commands.add(CommandFactory.createCommand("rotate", Direction.SOUTH));
        commands.add(CommandFactory.createCommand("activatepanels", null));
        commands.add(CommandFactory.createCommand("collectdata", null));

        for (Command command : commands) {
            commandSystem.executeCommand(command, satellite);
        }

        System.out.println("\n=== Final Satellite State: === ");
        satellite.printStatus();
    }
}