package org.scaler.ttt.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private int dimension;

    public List<List<Cell>> getGrid() {
        return grid;
    }

    private List<List<Cell>> grid;

    public int getDimension() {
        return dimension;
    }


    public Board(int dimension) {
        this.dimension = dimension;
        this.grid = new ArrayList<>();

        //construct a 2d matrix kind to represent GRID
        for(int i=0;i< dimension;i++){
            grid.add (new ArrayList<>());
            for (int j =0;j< dimension;j++){
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public Cell getCell(int row, int col){
        if (isValidCell(row, col)){
            return grid.get(row).get(col);
        }
        return null;
    }

    boolean isValidCell(int row, int col){
        return row >=0 && row < dimension && col >=0 && col< dimension;
    }

    public void printBoard() {
        for (int i = 0; i < dimension; i++) {
            System.out.println();
            List<Cell> rows = grid.get(i);
            for (int j = 0; j < dimension; j++) {
                Cell cell = rows.get(j);
                Symbol symbol = cell.getSymbol();
                if (symbol == null) {
                    System.out.print("| |");
                } else {
                    System.out.print("|" + symbol.getSymbol() + "|");
                }
            }
        }
        System.out.println();
    }

}
