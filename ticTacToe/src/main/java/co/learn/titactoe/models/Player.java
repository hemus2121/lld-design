package co.learn.titactoe.models;

import co.learn.titactoe.models.Enum.PlayerTypeEnum;

public abstract class Player {
    private Symbol symbol;
    private PlayerTypeEnum playerTypeEnum;

    Player(Symbol symbol, PlayerTypeEnum playerTypeEnum){
        this.symbol = symbol;
        this.playerTypeEnum = playerTypeEnum;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerTypeEnum getPlayerTypeEnum() {
        return playerTypeEnum;
    }

    public void setPlayerTypeEnum(PlayerTypeEnum playerTypeEnum) {
        this.playerTypeEnum = playerTypeEnum;
    }


    abstract Move makeMove(Board board);
}
