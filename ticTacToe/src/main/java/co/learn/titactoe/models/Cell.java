package co.learn.titactoe.models;

public class Cell {
    private int row;
    private int col;

    private Symbol symbol;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void clearCell(){
        this.symbol =null;
    }

    public boolean isEmpty(){
        return this.symbol ==null;
    }


}
