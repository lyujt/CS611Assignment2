public class Block {
    private boolean isOccupied;
    private Piece piece;
    private TicTacToe game;

    // default constructor
    public Block(){
        isOccupied = false;
    }

    // construct with a piece
    public Block(Piece pce){
        piece = pce;
        isOccupied = true;
    }
    public Block(int innerSize,int innerCond,TurnManager manager){
        game = new TicTacToe(innerSize,innerCond,manager);
        isOccupied = false;
    }

    // check if the block is occupied
    public boolean isOccupied() {
        return isOccupied;
    }

    // return the game in the block
    public TicTacToe getGame() {
        return game;
    }

    // get the piece in the block
    public Piece getPiece(){
        return piece;
    }

    // set a piece on the block
    public void setPiece(Piece piece) {
        this.piece = piece;
        isOccupied = true;
    }
}
