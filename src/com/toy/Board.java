package com.toy;

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

    public boolean isValidMove(int row, int column) {
        if (!(row >= 0 && row <= rows)) return false;
        else if (!(column >= 0 && column <= columns)) return false;
        else return true;
    }
}
