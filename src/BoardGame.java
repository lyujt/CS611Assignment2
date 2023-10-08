import java.util.Scanner;


abstract class BoardGame {
    protected Board board;
    protected int boardSize;
    protected int winCond;
    protected TurnManager turnManager;
    protected boolean isOver = false;
    protected InputManager input;
    protected Judge judge;
    protected static int DRAW = 1;

    protected static int WIN = 2;

    // construct with board size, winning condition and turn manager
    public BoardGame(int size, int cond, TurnManager manager){
        turnManager = manager;
        boardSize = size;
        winCond = cond;
        board = new Board(size);
        isOver = false;
        judge = new Judge(boardSize,winCond);
        input = new InputManager();
    }

    // construct with configuration of outer and inner board
    public BoardGame(int outerSize, int outerCond,int innerSize, int innerCond, TurnManager manager){
        turnManager = manager;
        boardSize = outerSize;
        winCond = outerCond;
        board = new SuperBoard(outerSize,innerSize,innerCond,manager);
        isOver = false;
        judge = new Judge(boardSize,winCond);
        input = new InputManager();
    }

    //show the current board
    public void displayBoard() {
        for(int i = 0; i < boardSize; i++){
            System.out.print("+---");
        }
        System.out.print("+\n");
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                System.out.print("| " + board.getValue(i,j) + " ");
            }
            System.out.print("|\n");
            for(int j = 0; j < boardSize; j++){
                System.out.print("+---");
            }
            System.out.print("+\n");
        }
    }

    // main game procedure
    public void play() {
        Player currentPlayer = turnManager.getCurrentPlayer();
        while (!isOver){
            displayBoard();
            int pos = move(board,currentPlayer);
            boolean win = isWin(pos / boardSize,pos % boardSize);
            boolean draw = isDraw();
            if (win || draw) {
                displayBoard();
                claimResult(win,currentPlayer);
                System.out.println("Team 1 score: "+ turnManager.getTeam(0).getScore());
                System.out.println("Team 2 score: "+ turnManager.getTeam(1).getScore());
                isOver = true;
                String res;
                do {
                    System.out.println("Restart?(y/n)");
                    res = input.getString();
                }while (!res.equals("y")&&!res.equals("n"));
                if(res.equals("y")){
                    board.clear();
                    isOver = false;
                }
                do {
                    System.out.println("Start a new game?(y/n)");
                    res = input.getString();
                }while (!res.equals("y")&&!res.equals("n"));
                if(res.equals("y")){
                    board.clear();
                    GameSelector gs = new GameSelector();
                }
            } else {
                // Switch to the other player
                currentPlayer = turnManager.takeTurns();
            }
        }
    }

    // play in an inner game
    public int partialPlay(){
        Player currentPlayer = turnManager.getCurrentPlayer();
        displayBoard();
        int ret = 0;
        int pos = move(board, currentPlayer);
        if(isDraw()){
            ret = DRAW;
            System.out.println("Inner game draw!");
            isOver = true;
        }
        else if(isWin(pos / boardSize,pos % boardSize)){
            ret = WIN;
            System.out.println("Inner game won!");
            isOver = true;
        }
        return ret;
    }


    // player makes a move
    abstract int move(Board board, Player currentPlayer);

    // claim a win or draw
    abstract void claimResult(boolean win, Player currentPlayer);

    // check if it's a win
    public boolean isWin(int row, int col){
        String type = board.getValue(row,col);
        return judge.checkRowWin(board,row,col,type) || judge.checkColWin(board,row,col,type) || judge.checkDiagonalWin(board,row,col,type);
    }

    // check if it's a draw
    public boolean isDraw(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(!board.isOccupied(i,j)) return false;
            }
        }
        return true;
    }

    public boolean isOver(){
        return isOver;
    }
}


