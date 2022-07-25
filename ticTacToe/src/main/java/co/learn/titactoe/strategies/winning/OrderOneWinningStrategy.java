package co.learn.titactoe.strategies.winning;

import co.learn.titactoe.models.Board;
import co.learn.titactoe.models.Cell;
import co.learn.titactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements GameWinningStrategy {

    private List<Map<Character, Integer>> rowCharCountList;
    private List<Map<Character, Integer>> colCharCountList;
    private List<Map<Character, Integer>> leftDiaCharCountList;
    private List<Map<Character, Integer>> rightDiaCharCountList;

    private void initListMaps(int dimension){
        rowCharCountList = new ArrayList<>();
        colCharCountList = new ArrayList<>();
        leftDiaCharCountList = new ArrayList<>();
        rightDiaCharCountList = new ArrayList<>();

        for (int i =0;i< dimension;i++){
            rowCharCountList.add(new HashMap<>());
            colCharCountList.add(new HashMap<>());
            leftDiaCharCountList.add(new HashMap<>());
            rightDiaCharCountList.add(new HashMap<>());
        }
    }
    public boolean checkIfWon(Board board, Player player, Cell cell) {

        //check if values are already present
        if (rowCharCountList== null){
            initListMaps(board.getDimension());
        }

        int row = cell.getRow();
        int col = cell.getCol();

        //check row if own
        boolean rowCheck = updateAndCheckCount (board, player, row, rowCharCountList);

        //check col if own
        boolean colCheck =  updateAndCheckCount (board, player, col, rowCharCountList);


        //check for diagonals
        boolean leftDiagCheck=false;
        boolean rightDiagCheck= false;

        //left primary diagonal
        if (row ==col) {
             leftDiagCheck = updateAndCheckCount(board, player, row, leftDiaCharCountList);
        }

        //right secondary diagonal
        if (row+col == board.getDimension()-1){
            rightDiagCheck= updateAndCheckCount(board,player, row+col, rightDiaCharCountList);
        }
        return rowCheck|| colCheck|| leftDiagCheck || rightDiagCheck;
    }

    private boolean updateAndCheckCount(Board board, Player player, int row, List<Map<Character, Integer>> charCountList) {

        if (!charCountList.get(row).containsKey(player.getSymbol().getCharacter())){
            charCountList.get(row).put(player.getSymbol().getCharacter(),0);
        }
        //increment count if present
        charCountList.get(row).put(player.getSymbol().getCharacter(),charCountList.get(row).get(player.getSymbol().getCharacter())+1);

        return  charCountList.get(row).get(player.getSymbol().getCharacter()).equals(board.getDimension());
    }
}
