package org.scaler.ttt.models;

import lombok.Data;

@Data
public abstract class Player {
    private long id;
    protected String name;
    protected Symbol symbol;
    protected PlayerType playerType;

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public abstract  Move makeMove(Board board);


}
