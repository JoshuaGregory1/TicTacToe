package com.mycompany.tictactoeproject;


/**
 * Class which defines the board
 */
public class Board {
    private Tile[][] board;
    private final int rows = 3;
    private final int cols = 3;
    
    public Board(){
        this.board = new Tile[rows][cols];
        setUp();
    }
    
    public void setUp(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = Tile.EMPTY;
            }
        }
    }

    //only good for 3x3 grid
    public void show(){
        //todo print board out
        System.out.println("Current Board:");
        /*System.out.println("   1   2   3\n" +
                           "1    |   |  \n" +
                           "  -----------\n" +
                           "2    |   |  \n" +
                           "  -----------\n" +
                           "3    |   |  ");
        */
        System.out.println("   1   2   3\n" +
                           "1  "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+"\n" +
                           "  -----------\n" +
                           "2  "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+"\n" +
                           "  -----------\n" +
                           "3  "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+"");
    }
    
    /**
     * 
     * @param row row coordinate of tile to insert
     * @param col column coordinate of tile to insert
     * @param player player 1 or 2
     * @return true if valid move
     */
    public boolean placeTile(int row, int col, int player){
        row--;
        col--;
        if (board[row][col] == Tile.EMPTY) {
            if (player == 1) {
                board[row][col] = Tile.CROSS;
                return true;
            } else {
                board[row][col] = Tile.NOUGHT;
                return true;
            }
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }
    

    public boolean checkVictory(int player){
        boolean win = false;
        switch(player) {
            //checking x
            case 1:
                win = checkAllWinStates(Tile.CROSS);
                break;
            //checking o
            case 2:
                win = checkAllWinStates(Tile.NOUGHT);
                break;
            default:
                System.out.println("Error");
        }

        return win;
    }
    
    private boolean checkAllWinStates(Tile tile){
        //all rows
        for (int i = 0; i < rows; i++) {
            if(board[i][0].equals(tile) && board[i][1].equals(tile) && board[i][2].equals(tile)){
                return true;
            }
        }
        //all cols
        for (int j = 0; j < cols; j++) {
            if(board[0][j].equals(tile) && board[1][j].equals(tile) && board[2][j].equals(tile)){
                return true;
            }
        }
        //both diagonals
        if(board[1][1].equals(tile)){
            if(board[0][0].equals(tile) && board[2][2].equals(tile)){
                return true;
            }
            if(board[0][2].equals(tile) && board[2][0].equals(tile)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean checkFull(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //still at least 1 empty tile left
                if(board[i][j].equals(Tile.EMPTY)){
                    return false;
                }
            }
        }
        //full board
        return true;
    }
    
}
