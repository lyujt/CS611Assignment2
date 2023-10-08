public class Player {
    private final String name;
    private Piece piece;
    // construct player with name (OC)
    public Player(String name){
        this.name = name;
    }

    // construct player with name and piece (TTT)
    public Player(String name,Piece piece){
        this.name = name;
        this.piece = piece;
    }

    // get player's name
    public String getName() {
        return name;
    }

    // get player's piece
    public Piece getPiece() {
        return piece;
    }


}
