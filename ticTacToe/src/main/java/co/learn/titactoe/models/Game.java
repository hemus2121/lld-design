package co.learn.titactoe.models;

import co.learn.titactoe.exception.EmptyMoveUndoOperationException;
import co.learn.titactoe.exception.MultipleBotException;
import co.learn.titactoe.models.Enum.GameStatusEnum;
import co.learn.titactoe.models.Enum.PlayerTypeEnum;
import co.learn.titactoe.strategies.winning.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int lastMovedPlayerIndex;
    private Player winner;
    private Board board;
    private GameStatusEnum gameStatusEnum;
    private List<GameWinningStrategy> gameWinningStrategyList;
    private List<Player> playerList;
    private List<Move> moveList;

    public int getLastMovedPlayerIndex() {
        return lastMovedPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public GameStatusEnum getGameStatusEnum() {
        return gameStatusEnum;
    }

    public List<GameWinningStrategy> getGameWinningStrategyList() {
        return gameWinningStrategyList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }


    //private constructor so that we use constructor to build object
    private Game(){
        this.gameWinningStrategyList = new ArrayList<>();
        this.playerList  = new ArrayList<>();
        this.moveList = new ArrayList<>();
        this.lastMovedPlayerIndex= -1;
        this.gameStatusEnum = GameStatusEnum.IN_PROGRESS;
    }

    public boolean undo() throws EmptyMoveUndoOperationException {
        if(this.moveList.size()==0){
            throw new EmptyMoveUndoOperationException();
        }
        Move lastMove = this.moveList.get(this.moveList.size()-1);
        Cell relevantCell = lastMove.getCell();
        relevantCell.clearCell();
        this.lastMovedPlayerIndex =-1;
        this.lastMovedPlayerIndex = (this.lastMovedPlayerIndex +this.playerList.size() )% this.playerList.size();
        this.moveList.remove(this.lastMovedPlayerIndex);
        return true;
    }
    public void makeMove(){
        this.lastMovedPlayerIndex +=1;
        this.lastMovedPlayerIndex = this.lastMovedPlayerIndex % this.playerList.size();

        Move move = this.playerList.get(lastMovedPlayerIndex).makeMove(this.board);
        this.moveList.add(move);
        move.getCell().setSymbol(move.getSymbol());

        // check if player won if yes revise GAME status
        for (GameWinningStrategy gameWinningStrategy : this.gameWinningStrategyList){
            if (gameWinningStrategy.checkIfWon(board, playerList.get(lastMovedPlayerIndex),move.getCell())){
                this.gameStatusEnum = GameStatusEnum.ENDED;
                this.winner = this.playerList.get(lastMovedPlayerIndex);
                return;
            }
        }
        //Check if NO more moves are allowed then its DRAW status
        if (moveList.size()== this.board.getDimension() * this.board.getDimension()){
            this.gameStatusEnum = GameStatusEnum.DRAW;
            return;
        }
    }


    //Builder class wrapper for Game class
    public static Builder create (){
        return new Builder();
    }

    //Builder class for Game class
    public static class Builder{
        private List<GameWinningStrategy> winningStrategyList;
        private List<Player> playerList;
        private int dimension;

        Builder(){
            winningStrategyList = new ArrayList<>();
            playerList = new ArrayList<>();
        }

        public Builder addPlayer(Player player){
            this.playerList.add(player);
            return this;
        }

        public Builder addPlayers(List<Player> playerList){
            this.playerList.addAll(playerList);
            return this;
        }

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder addGameWinningStrategy( GameWinningStrategy winningStrategy){
            this.winningStrategyList.add(winningStrategy);
            return  this;
        }

        public Builder addGameWinningStrategies(List<GameWinningStrategy>winningStrategyList){
            this.winningStrategyList.addAll(winningStrategyList);
            return this;
        }

        //bot validation as such 1 bot only
        int botCount=0;
        private boolean checkSingleBot(){
            for (Player player: playerList){
                if(player.getPlayerTypeEnum().equals(PlayerTypeEnum.BOT)){
                    botCount++;
                }
            }
            return  botCount<=1;
        }

        public Game build() throws MultipleBotException{
            if (!checkSingleBot()){
                throw new MultipleBotException();
            }

            Game game = new Game();
            game.playerList.addAll(this.playerList);
            game.gameWinningStrategyList.addAll(this.winningStrategyList);
            game.board = new Board(this.dimension);
            return  game;
        }

    }

    //Lets create a builder class



}
