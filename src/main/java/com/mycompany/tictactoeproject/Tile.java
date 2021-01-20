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

}

