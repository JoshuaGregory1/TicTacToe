package com.mycompany.tictactoeproject;

/**
 * Class that defines a tile on the Tic Tac Toe board
 * A Tile can be either empty, nought, or cross.
 */
public enum Tile {
    EMPTY(" "),
    NOUGHT("o"),
    CROSS("x");
    
    private final String label;
    
    private Tile(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return label;
    }
    
    //returns true if both input tiles are equal (equal by their strings)
    public boolean equals(Tile t1, Tile t2) {
        return t1.toString().equals(t2.toString());
    }
}

