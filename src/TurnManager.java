import java.util.ArrayList;
import java.util.List;

public class TurnManager {
    private final List<Team> teams;
    private final int[] currentPlayer;
    private int currentTeam;
    private int orderTeam;

    // constructor for tic-tac-toe
    public TurnManager(Team team1, Team team2) {
        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        currentPlayer = new int[]{0, 0};
        currentTeam = 0;
    }

    // constructor for order and chaos
    public TurnManager(Team team1, Team team2, int order) {
        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        currentPlayer = new int[]{0, 0};
        currentTeam = order;
        orderTeam = order;
    }

    // switch to the next player in next team
    public Player takeTurns(){
        currentPlayer[currentTeam] += 1;
        if(currentPlayer[currentTeam] == teams.get(currentTeam).getSize()){
            currentPlayer[currentTeam] = 0;
        }
        currentTeam = (currentTeam == 0) ? 1 : 0;
        return getCurrentPlayer();
    }

    // get current player
    public Player getCurrentPlayer(){
        return teams.get(currentTeam).getPlayer(currentPlayer[currentTeam]);
    }

    // get current team
    public Team getCurrentTeam() {
        return teams.get(currentTeam);
    }

    // get the order team
    public Team getOrderTeam() {
        return teams.get(orderTeam);
    }

    // get the chaos team
    public Team getChaosTeam() {
        return teams.get(1-orderTeam);
    }

    // get team by index
    public Team getTeam(int i) {
        return teams.get(i);
    }
}
