import java.util.*;

interface TeamMember {
    void displayDetails();
}

class Driver implements TeamMember {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Driver: " + name);
    }
}

class Engineer implements TeamMember {
    private String name;

    public Engineer(String name) {
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Engineer: " + name);
    }
}

class TeamComposite implements TeamMember {
    private List<TeamMember> members = new ArrayList<>();

    public void addMember(TeamMember member) {
        members.add(member);
    }

    public void removeMember(TeamMember member) {
        members.remove(member);
    }

    public void displayDetails() {
        for (TeamMember member : members) {
            member.displayDetails();
        }
    }
}

public class Main {
    public static void main(String args[]) {
        TeamComposite team = new TeamComposite();
        
        team.addMember(new Driver("Sebastian Vettel"));
        team.addMember(new Engineer("Manan Gupta"));

        System.out.println("\n=== Team Members ===");
        team.displayDetails();
    }
}
