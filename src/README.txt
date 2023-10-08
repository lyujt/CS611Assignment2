# CS611-Assignment 1
## Tic Tac Toe and other variants
---------------------------------------------------------------------------
Junting Lyu
lvjt@bu.edu
U49964288

## Files
---------------------------------------------------------------------------

Main.java: Entrance to the project.
InputManager.java: Detect input type errors.
GameSelector.java: Select game, enter team and player info, customize game rules.
TurnManager.java: Decide which team/player should play next.
Team.java: Info of two teams.
Player.java: Info of players .
BoardGame.java: Method to construct a game and display a board, and the main game procedure.
Board.java: A board holding blocks, can access or change values of them.
Block.java: A block to hold pieces.
Piece.java: Type of pieces (X/O).
TicTacToe.java: The move to be taken on a TicTacToe game, and the method to claim result.
OrderAndChaos.java: The move to be taken on a OrderAndChaos game, and the method to claim result.

HW2
Judge.java: Check in row, column and diagonals from a given block, decide if the winning condition is satisfied.
SuperTicTacToe.java: The move to be taken on a SuperTicTacToe game, and the method to claim result.
SuperBoard.java: The board for SuperTicTacToe, containing SuperBlocks.
SuperBlock.java: Contains an inner TicTacToe game, fill in pieces when the game is won or drew.

## Notes
---------------------------------------------------------------------------

1.There are two teams with arbitrary number of players.
2.Each player has a name and take turns by order of input.
3.Board size can be customized, but can only be a square.
4.Winning condition can be customized (between default condition and board size).
5.Input indices are simplified into integers (0 ~ boardSize^2)
6.Each team alternates players during each round.
7.Winnings are detected immediately, draws are detected when board is full.
8.Can start another round on current setting, starting with the last player in last round.
9.Each team has their scores recorded under one game setting.
10.Run the code again to change the settings of game and teams.

Changes made to HW1:
1.Set BoardGame class to abstract. Merged the main game procedure into BoardGame class, implementing abstract methods
.move() and .claimResult() under each game's class respectively.
2.Add judge class to reuse the code to check winning conditions.
3.Fixed user input error (negative players)
4.Can play interchanging games now. i.e. restart from very beginning.
5.Set max size, default(min) board size and default winning conditions as variables.
6.Players can now see the index of each unoccupied block.

HW2
1.In superTTT, players can change the board size and winning condition of both outer and inner games.
2.In every step, the UI firstly shows the outer board, and players will be asked to choose a block
(which contains an inner game that hasn't ended) to play on.
3.Then the UI will zoom into the inner board and ask the player to make a move.
4.If an inner game ends up a draw, a piece "-" will be placed on the outer board, which doesn't count for either team.


## How to compile and run
---------------------------------------------------------------------------

1. Navigate to the directory "YourCodeDirectory" after unzipping the files
2. Run the following instructions:
javac *.java -d bin
java -cp ./bin Main

## Input/Output Example
---------------------------------------------------------------------------


Super TicTcToe showcase:

Enter 1 for Tic-Tac-Toe, 2 for Order and Chaos, 3 for Super Tic-Tac-Toe
3
Would you like to customize the game?(y/n)
y
Please enter the name of team 1
a
Please enter the number of players in team 1
1
Please enter the name of team 2
b
Please enter the number of players in team 2
1
Please choose side for team 1.(X/O)
X
Please enter the name of player 1, team a
a
Please enter the name of player 1, team b
b
Please enter the OUTER board size between 3 and 8.
3
Please enter the OUTER winning condition between 3 and board size.
3
Please enter the INNER board size between 3 and 8.
3
Please enter the INNER winning condition between 3 and board size.
3
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, a
0
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Please make your move, a
0
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, b
0
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Please make your move, b
1
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, a
0
+---+---+---+
| X | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Please make your move, a
4
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, b
0
+---+---+---+
| X | O |   |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+---+---+---+
Please make your move, b
2
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, a
0
+---+---+---+
| X | O | O |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+---+---+---+
Please make your move, a
8
Inner game won!
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, b

......

+---+---+---+
| X | - | X |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+---+---+---+
Choose a board to play on, a
6
+---+---+---+
| O | X | O |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   | O |
+---+---+---+
Please make your move, a
7
Inner game won!
+---+---+---+
| X | - | X |
+---+---+---+
|   | X |   |
+---+---+---+
| X |   |   |
+---+---+---+
Player a wins!
Team 1 score: 1
Team 2 score: 0
Restart?(y/n)
n
Start a new game?(y/n)
y
Please choose a game mode.
Enter 1 for Tic-Tac-Toe, 2 for Order and Chaos, 3 for Super Tic-Tac-Toe

......