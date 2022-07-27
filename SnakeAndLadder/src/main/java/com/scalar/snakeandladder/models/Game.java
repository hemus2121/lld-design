package com.scalar.snakeandladder.models;

import com.scalar.snakeandladder.models.enums.GameStatusEnum;
import lombok.Data;

import java.util.List;

@Data
public class Game {
    private Board board;
    private Dice dice;
    private List<Player> playerList;
    private int totalButtonsPerPlayer;
    private GameStatusEnum gameStatus;
    private List<Player> ranking;
    private int lastPlayerMovedIndex;

}
