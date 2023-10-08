import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SuperTicTacToe extends BoardGame {

    // inherited constructor from board game
    public SuperTicTacToe(int outerBoardSize, int outerWinCond, int innerBoardSize, int innerWinCond, TurnManager manager) {
        super(outerBoardSize, outerWinCond,innerBoardSize,innerWinCond, manager);
    }

    // choose the board to play on
    public int move(Board board, Player currentPlayer) {
        int pos = -1,i,j;
        do {
            System.out.println("Choose a board to play on, " + currentPlayer.getName());
            pos = input.getInt();
            i = pos / board.getSize();
            j = pos % board.getSize();
        }while(pos < 0 || pos >= board.getSize()* board.getSize() || board.isOver(i,j));
        int res = board.play(i,j);
        if(res == DRAW){
            board.setValue(new Piece("-"),i,j);
        }else if(res == WIN){
            board.setValue(currentPlayer.getPiece(),i,j);
        }
        return pos;
    }

    // declare a win or draw
    public void claimResult(boolean win, Player currentPlayer){
        if (win) {
            System.out.println("Player " + currentPlayer.getName() + " wins!");
            turnManager.getCurrentTeam().winScore();
        } else {
            System.out.println("It's a draw!");
        }
    }
}
