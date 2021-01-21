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
                
                String row;
                String col;
                boolean invalidMove = true;
                while(invalidMove){
                    System.out.println("");
                    System.out.println("Player " + currentPlayer + "'s Turn (" + this.returnLabel(currentPlayer) + ")...");

                    //input row
                    System.out.println("Choose row: ");
                    row = sc.nextLine();
                    while (!row.matches("[1-3]")) {
                        System.out.println("Incorrect input, please enter again.");
                        row = sc.nextLine();
                    }
                    
                    //input column
                    System.out.println("Choose column: ");
                    col = sc.nextLine();
                    while (!col.matches("[1-3]")) {
                        System.out.println("Incorrect input, please enter again.");
                        col = sc.nextLine();
                    }


                    if(board.placeTile(Integer.parseInt(row), Integer.parseInt(col), currentPlayer)){
                        invalidMove = false;
                    }
                }
               
                if(board.checkVictory(currentPlayer)){
                    noVictoryOrFull = false;
                    board.show();
                    System.out.println("Player " + currentPlayer + " Wins!");
                } else if(board.checkFull()){
                    noVictoryOrFull = false;
                    board.show();
                    System.out.println("It's a draw!");
                }
            }
           
            //play again?
            System.out.println("Play again (y/n)?");
            String input = sc.nextLine();
            if (input.equals("n")){
                playAgain = false;
            }
            board.setUp();
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
