package com.nibir;

public class Board {
    private int rows;
    private int columns;

    public Board() { }

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean isValidPosition(int row, int column) {
        return !(row > this.rows || row < 0 || column > this.columns || column < 0);
    }
}
