package com.mycompany.tictactoeproject;


/**
 * Class which defines the board
 */
public class Board {
    private Tile[][] board;
    
    public Board(){
        this.board = new Tile[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Tile.CROSS;
            }
        }
    }
    
    public String show(){
        //todo print board out
        return "";
    }
    
    
    public void placeTile(){
        
       
    }
    
    public void checkVictory(){
        
    }
    
}
