package F_Generics.src;


public class Main {
    public static void main(String[] args) {
        BaseballTeam phillies = new BaseballTeam("Philies");
        BaseballTeam astros = new BaseballTeam("Astros");
        scoreResult(phillies, astros, 3,5);

        phillies.addPlayer(new BaseballPlayer("Harper", "Righter"));
        phillies.addPlayer(new BaseballPlayer("Marsh", "Righter"));
        phillies.listMembers();


        Team<BaseballPlayer> phillies1 = new Team<>("Philadelphia Phillies");
        Team<BaseballPlayer> astros1 = new Team<>("Houston Astros");
        scoreResult(phillies1, astros1,3,  5);


    }

    public static void scoreResult(BaseballTeam team1, BaseballTeam team2, int t1_score, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    public static void scoreResult(Team team1, Team team2, int t1_score, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
