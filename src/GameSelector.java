import java.util.Scanner;

public class GameSelector {
    private static final int defaultBoardSizeTTT = 3;
    private static final int defaultWinCondTTT = 3;
    private static final int maxSizeTTT = 8;
    private static final int defaultBoardSizeOC = 6;
    private static final int defaultWinCondOC = 5;
    private static final int maxSizeOC = 11;

    //test if the board size is valid
    private static boolean isValidBoardSize(int boardSize, int gameMode) {
        if(gameMode == 1 || gameMode == 3) {
            if (boardSize < defaultBoardSizeTTT || boardSize > maxSizeTTT) {
                System.out.println("Invalid board size. Try again.");
                return false;
            }
        }
        else if(gameMode == 2) {
            if(boardSize < defaultBoardSizeOC || boardSize > maxSizeOC) {
                System.out.println("Invalid board size. Try again.");
                return false;
            }
        }
        return true;
    }

    //test if the winning condition is valid
    private static boolean isValidWinCondition(int winCond, int gameMode, int boardSize){
        if(gameMode == 1 || gameMode == 3) {
            if (winCond < defaultWinCondTTT || winCond > boardSize) {
                System.out.println("Invalid winning condition. Try again.");
                return false;
            }
        }
        else if(gameMode == 2) {
            if(winCond < defaultWinCondOC || winCond > boardSize) {
                System.out.println("Invalid winning. Try again.");
                return false;
            }
        }
        return true;
    }


    // choose a game and its settings
    public GameSelector() {
        InputManager input = new InputManager();

        System.out.println("Please choose a game mode.");

        int gameMode;
        do {
            System.out.println("Enter 1 for Tic-Tac-Toe, 2 for Order and Chaos, 3 for Super Tic-Tac-Toe");
            gameMode = input.getInt();
        }while (gameMode != 1 && gameMode != 2 && gameMode != 3);

        String isCustimized;
        do{
            System.out.println("Would you like to customize the game?(y/n)");
            isCustimized = input.getString();
        }while (!isCustimized.equals("y")  && !isCustimized.equals("n"));

        String t1name,t2name,t1side;
        int t1num,t2num;
        Piece X = new Piece("X");
        Piece O = new Piece("O");

        System.out.println("Please enter the name of team 1");
        t1name = input.getString();
        do {
            System.out.println("Please enter the number of players in team 1");
            t1num = input.getInt();
        }while (t1num <= 0);


        System.out.println("Please enter the name of team 2");
        t2name = input.getString();
        do {
            System.out.println("Please enter the number of players in team 2");
            t2num = input.getInt();
        }while (t2num <= 0);


        int boardSize,winCond;
        Team t1,t2;
        TurnManager manager;
        if (gameMode == 1) {
            do {
                System.out.println("Please choose side for team 1.(X/O)");
                t1side = input.getString();
            } while (!t1side.equals("X") && !t1side.equals("O"));

            if (t1side.equals("X")) {
                t1 = new Team(t1num, t1name, X); //initialize by piece X/O
                t2 = new Team(t2num, t2name, O);
            } else {
                t1 = new Team(t1num, t1name, O);
                t2 = new Team(t2num, t2name, X);
            }

            manager = new TurnManager(t1, t2);

            if(isCustimized.equals("y")) {
                do {
                    System.out.println("Please enter the board size between 3 and 8.");
                    boardSize = input.getInt();
                } while (!isValidBoardSize(boardSize, gameMode));
                do {
                    System.out.println("Please enter the winning condition between 3 and board size.");
                    winCond = input.getInt();
                } while (!isValidWinCondition(winCond, gameMode, boardSize));

                TicTacToe game = new TicTacToe(boardSize, winCond, manager);
                game.play();
            }else{
                TicTacToe game = new TicTacToe(defaultBoardSizeTTT, defaultWinCondTTT, manager);
                game.play();
            }

        }
        if (gameMode == 2) {

            do {
                System.out.println("Please choose side for team 1.(C/O)");
                t1side = input.getString();
            } while (!t1side.equals("C") && !t1side.equals("O"));

            if (t1side.equals("C")) {
                t1 = new Team(t1num, t1name, "C");// initialize by side O/C
                t2 = new Team(t2num, t2name, "O");
                manager = new TurnManager(t1, t2, 1);
            } else {
                t1 = new Team(t1num, t1name, "O");
                t2 = new Team(t2num, t2name, "C");
                manager = new TurnManager(t1, t2, 0);
            }

            if(isCustimized.equals("y")) {
                do {
                    System.out.println("Please enter the board size between 6 and 11.");
                    boardSize = input.getInt();
                } while (!isValidBoardSize(boardSize, gameMode));
                do {
                    System.out.println("Please enter the winning condition between 5 and board size.");
                    winCond = input.getInt();
                } while (!isValidWinCondition(winCond, gameMode, boardSize));

                OrderAndChaos game = new OrderAndChaos(boardSize, winCond, manager);
                game.play();
            }else{
                OrderAndChaos game = new OrderAndChaos(defaultBoardSizeOC, defaultWinCondOC, manager);
                game.play();
            }

        }
        if (gameMode == 3) {
            do {
                System.out.println("Please choose side for team 1.(X/O)");
                t1side = input.getString();
            } while (!t1side.equals("X") && !t1side.equals("O"));

            if (t1side.equals("X")) {
                t1 = new Team(t1num, t1name, X); //initialize by piece X/O
                t2 = new Team(t2num, t2name, O);
            } else {
                t1 = new Team(t1num, t1name, O);
                t2 = new Team(t2num, t2name, X);
            }

            manager = new TurnManager(t1, t2);

            if(isCustimized.equals("y")) {
                do {
                    System.out.println("Please enter the OUTER board size between 3 and 8.");
                    boardSize = input.getInt();
                } while (!isValidBoardSize(boardSize, gameMode));
                do {
                    System.out.println("Please enter the OUTER winning condition between 3 and board size.");
                    winCond = input.getInt();
                } while (!isValidWinCondition(winCond, gameMode, boardSize));
                int innerSize;
                do {
                    System.out.println("Please enter the INNER board size between 3 and 8.");
                    innerSize = input.getInt();
                } while (!isValidBoardSize(innerSize, gameMode));
                int innerCond;
                do {
                    System.out.println("Please enter the INNER winning condition between 3 and board size.");
                    innerCond = input.getInt();
                } while (!isValidWinCondition(innerCond, gameMode, innerSize));
                SuperTicTacToe game = new SuperTicTacToe(boardSize, winCond, innerSize, innerCond, manager);
                game.play();
            }else{
                SuperTicTacToe game = new SuperTicTacToe(defaultBoardSizeTTT, defaultWinCondTTT, defaultBoardSizeTTT, defaultWinCondTTT, manager);
                game.play();
            }

        }
    }
}

