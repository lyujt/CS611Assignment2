public class Judge {
    private final int boardSize;
    private final int winCond;

    // construct by board size and winning condition
    public Judge(int boardSize, int winCond) {
        this.boardSize = boardSize;
        this.winCond = winCond;
    }

    // check if it's a win in row
    public boolean checkRowWin(Board board, int row, int col, String type) {
        if(type.equals(" ") || type.equals("-")) return false;
        int pieceInLine = 1, curCol = col;
        while (--curCol >= 0 && board.getValue(row, curCol).equals(type)) pieceInLine++;
        curCol = col;
        while (++curCol < boardSize && board.getValue(row, curCol).equals(type)) pieceInLine++;
        return pieceInLine >= winCond;
    }

    // check if it's a win in column
    public boolean checkColWin(Board board, int row, int col, String type) {
        if(type.equals(" ")|| type.equals("-")) return false;
        int pieceInLine = 1 ,curRow = row;
        while(--curRow >= 0 && board.getValue(curRow,col).equals(type)) pieceInLine++;
        curRow = row;
        while(++curRow < boardSize && board.getValue(curRow,col).equals(type)) pieceInLine++;
        return pieceInLine >= winCond;
    }

    // check if it's a win in diagonals
    public boolean checkDiagonalWin(Board board, int row, int col, String type){
        if(type.equals(" ")|| type.equals("-")) return false;
        int pieceInLine = 1,curRow = row, curCol = col;
        while(--curCol >= 0 && --curRow >= 0 && board.getValue(curRow,curCol).equals(type)) pieceInLine++;
        curRow = row;
        curCol = col;
        while(++curCol < boardSize && ++curRow < boardSize && board.getValue(curRow,curCol).equals(type)) pieceInLine++;
        curRow = row;
        curCol = col;
        if(pieceInLine >= winCond) return true;
        else pieceInLine = 1;

        while(--curCol >= 0 && ++curRow < boardSize && board.getValue(curRow,curCol).equals(type)) pieceInLine++;
        curRow = row;
        curCol = col;
        while(++curCol < boardSize && --curRow >= 0 && board.getValue(curRow,curCol).equals(type)) pieceInLine++;
        return pieceInLine >= winCond;
    }
}