package co.learn.titactoe.models;

import co.learn.titactoe.models.Enum.PlayerTypeEnum;

public abstract class Player {
    private Symbol symbol;
    private PlayerTypeEnum playerTypeEnum;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    Player(Symbol symbol, PlayerTypeEnum playerTypeEnum,String name){
        this.symbol = symbol;
        this.playerTypeEnum = playerTypeEnum;
        this.name = name;
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
