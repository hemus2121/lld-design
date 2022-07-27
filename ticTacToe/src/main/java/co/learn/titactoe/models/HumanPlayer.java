package co.learn.titactoe.models;

import co.learn.titactoe.models.Enum.PlayerTypeEnum;

import java.util.Scanner;

public class HumanPlayer extends  Player {

    public HumanPlayer(PlayerTypeEnum playerTypeEnum, Symbol symbol, String playerName){
        super(symbol, playerTypeEnum, playerName);
    }
    @Override
    Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell Row Number starting from 1");
        int row =scanner.nextInt();

        System.out.println("Tell Column Number starting from 1");
        int col = scanner.nextInt();

        Move move = new Move();
        move.setPlayer(this);
        move.setSymbol(this.getSymbol());
        move.setCell(board.getCell(row-1, col-1));

        return move;
    }
}
