package co.learn.titactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> boardList;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<List<Cell>> boardList) {
        this.boardList = boardList;
    }


    //Constructor - init board and cell
    public  Board (int dimension){
        this.dimension = dimension;
        this.boardList = new ArrayList<>();
        for (int  row=0;row<dimension ;row++){
            this.boardList.add(new ArrayList<>());
            for (int col = 0; col < dimension; ++col) {
                this.boardList.get(col).add(new Cell());
            }
        }
    }

    public Cell getCell(int i, int j) {
        return boardList.get(i).get(j);
    }
    public List<List<Cell>> getBoard(){
        return  this.boardList;
    }

    public void display(){
        for (List<Cell> row : boardList){
            for (Cell cell: row){
                if (cell.getSymbol()== null){
                    System.out.print("|  |");
                }else {
                    System.out.printf("| " + cell.getSymbol().getCharacter() + " |");
                }
            }
            System.out.println("\n");
        }
    }

}
