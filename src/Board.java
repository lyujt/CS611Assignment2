import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Block>> board;

    private final int size;

    // construct by size
    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Block> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Block());
            }
            board.add(row);
        }
    }

    /// construct a board with inner games
    public Board(int outerSize,int innerSize, int innerCond, TurnManager manager){
        this.size = outerSize;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Block> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new SuperBlock(innerSize,innerCond,manager));
            }
            board.add(row);
        }
    }

    // get board size
    public int getSize(){
        return size;
    }

    // set a piece to a given position
    public void setValue(Piece piece, int i, int j) {
        board.get(i).get(j).setPiece(piece);
    }

    // check if the block in given position is occupied
    public boolean isOccupied(int i, int j){
        return board.get(i).get(j).isOccupied();
    }

    // check if the game is over
    public boolean isOver(int i, int j) { return board.get(i).get(j).getGame().isOver();}

    // play the game in the given block
    public int play(int i, int j){ return  board.get(i).get(j).getGame().partialPlay();}

    // get value from a given position
    public String getValue( int i, int j) {
        Block tmp = board.get(i).get(j);
        if(tmp.isOccupied()) {
            return board.get(i).get(j).getPiece().getType();
        }else{
            return ""+(i*size+j);
        }
    }

    //clear the board
    public void clear(){
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Block> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Block());
            }
            board.add(row);
        }
    }
}
