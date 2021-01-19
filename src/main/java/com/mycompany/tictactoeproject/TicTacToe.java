package com.mycompany.tictactoeproject;
import java.util.Scanner;

/**
 * Main class for Tic Tac Toe
 */
public class TicTacToe {
    
    public Scanner sc = new Scanner(System.in);
    public Board board;
    public int currentPlayer;
    
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");
        TicTacToe game = new TicTacToe();
        game.run();

    }
    
    public void run(){
        this.board = new Board();
        boolean playAgain = true;
        while(playAgain){
            currentPlayer = 2;
            boolean noVictoryOrFull = true;
            while(noVictoryOrFull){
                System.out.println("----------------------");
                board.show();
                
                //player switch, default starts at 1
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }
                
                int row = 0;
                int col = 0;
                boolean invalidMove = true;
                while(invalidMove){
                    System.out.println("");
                    System.out.println("Player " + currentPlayer + "'s Turn (" + this.returnLabel(currentPlayer) + ")...");

                    System.out.println("Choose row: ");
                    row = sc.nextInt();

                    System.out.println("Choose column: ");
                    col = sc.nextInt();

                    if(board.placeTile(row, col, currentPlayer)){
                        invalidMove = false;
                    }
                }
                
                if(board.checkVictory(row, col, currentPlayer)){
                    noVictoryOrFull = false;
                    System.out.println("Player" + currentPlayer + "Wins!");
                }
                
                if(board.checkFull()){
                    noVictoryOrFull = false;
                    System.out.println("It's a draw!");
                }

            }
            
            //play again?
            //this is bugged i think
            System.out.println("Play again (y/n)?");
            String input = sc.nextLine();
            if (input.equals("n")){
                board.setUp();
                playAgain = false;
            }
        }
    }
    
    public String returnLabel(int player){
        if(player == 1){
            return "x";
        } else {
            return "o";
        }
    }
    

}
