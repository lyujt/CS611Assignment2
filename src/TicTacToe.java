public class TicTacToe extends BoardGame {
    // inherited constructor from board game
    public TicTacToe(int boardSize, int winCond, TurnManager manager) {
        super(boardSize, winCond, manager);

    }

    // make a move in TTT
    public int move(Board board, Player currentPlayer) {
        int pos = -1,i,j;
        do {
            System.out.println("Please make your move, " + currentPlayer.getName());
            pos = input.getInt();
            i = pos / board.getSize();
            j = pos % board.getSize();
        }while(pos < 0 || pos >= board.getSize()* board.getSize() || board.isOccupied(i,j));
        board.setValue(currentPlayer.getPiece(),i,j);
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
