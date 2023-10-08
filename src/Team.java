import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Player> players;
    private int score = 0;
    private final int size;
    private final InputManager input;


    // construct by side (O/C) in OC
    public Team(int size, String name, String side) {
        players = new ArrayList<Player>();
        this.name = name;
        this.size = size;
        score = 0;
        input = new InputManager();
        for(int i = 1; i <= size; i++){
            System.out.println("Please enter the name of player " + i + ", team " + name);
            String playerName = input.getString();
            players.add(new Player(playerName));
        }
    }

    //construct by piece (O/X) in TTT
    public Team(int size, String name, Piece piece) {
        players = new ArrayList<Player>();
        this.name = name;
        this.size = size;
        score = 0;
        input = new InputManager();
        for(int i = 1; i <= size; i++){
            System.out.println("Please enter the name of player " + i + ", team " + name);
            String playerName = input.getString();
            players.add(new Player(playerName,piece));
        }
    }

    // get team's size
    public int getSize(){
        return size;
    }

    // get player by index
    public Player getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    // increase score by 1
    public void winScore(){
        score += 1;
    }

    // get team's score
    public int getScore(){
        return score;
    }

    // get team's name
    public String getName() {
        return name;
    }
}
