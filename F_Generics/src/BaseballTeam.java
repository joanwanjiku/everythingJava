package F_Generics.src;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {
    private String name;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String name) {
        this.name = name;
    }

    public void addPlayer(BaseballPlayer player) {
        if (!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listMembers(){
        System.out.println("Team Members:");
        for (BaseballPlayer player : teamMembers) {
            System.out.println(player.name());
        }
    }
    public int ranking(){
       return (totalLosses * 2) + totalTies +1 ;
    }

    public String setScore(int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            totalWins++;
            return "Team " + name + " wins!";
        } else if (ourScore < theirScore) {
            totalLosses++;
            return "Team " + name + " loses!";
        } else {
            totalTies++;
            return "Team " + name + " ties!";
        }
    }
    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", teamMembers=" + teamMembers +
                ", totalWins=" + totalWins +
                ", totalLosses=" + totalLosses +
                ", totalTies=" + totalTies +
                '}';
    }
}
