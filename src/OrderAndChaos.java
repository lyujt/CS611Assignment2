public class OrderAndChaos extends BoardGame {

    // inherited constructor from board game
    public OrderAndChaos(int boardSize, int winCond, TurnManager turnManager) {
        super(boardSize, winCond, turnManager);
    }

    // make a move in OC
    public int move(Board board, Player currentPlayer) {
        int pos = -1,i,j;
        String type;
        Piece piece;
        do {
            System.out.println("Please make your move, " + currentPlayer.getName());
            pos = input.getInt();     // Input "int \n X/O"
            type = input.getString();
            piece = new Piece(type);
            i = pos / board.getSize();
            j = pos % board.getSize();
        }while(pos < 0 || pos >= board.getSize()* board.getSize() || board.isOccupied(i,j) || (!type.equals("X") && !type.equals("O")));
        board.setValue(piece,i,j);
        return pos;
    }

    // show the winning team
    public void claimResult(boolean orderWin, Player player){
        if (orderWin) {
            System.out.println("Team " + turnManager.getOrderTeam().getName() + " wins!");
            turnManager.getOrderTeam().winScore();
        } else {
            System.out.println("Team " + turnManager.getChaosTeam().getName() + " wins!");
            turnManager.getChaosTeam().winScore();
        }
    }

}
