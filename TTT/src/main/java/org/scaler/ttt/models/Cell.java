package org.scaler.ttt.models;

public class Cell {
    private int row, col;
    private Symbol symbol;
    Cell (int row, int cow){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void clearCell(){
        this.symbol = null;
    }


}
