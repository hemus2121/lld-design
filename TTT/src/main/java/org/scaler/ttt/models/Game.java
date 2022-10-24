package org.scaler.ttt.models;

import org.scaler.ttt.exceptions.InvalidUndoOperation;
import org.scaler.ttt.exceptions.MultipleBotException;
import org.scaler.ttt.strategy.winning.WinningStrategy;

import java.util.List;
import java.util.Objects;

public class Game {

    private List<Player> playersList;
    private Board board;

    private List <WinningStrategy> winningStrategyList;

    private Player winner;

    private List<Move> movesList;

    private int lastPlayerMovedIndex;

    private GameStatus gameStatus;


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public int getLastPlayerMovedIndex() {
        return lastPlayerMovedIndex;
    }

    public void setLastPlayerMovedIndex(int lastPlayerMovedIndex) {
        this.lastPlayerMovedIndex = lastPlayerMovedIndex;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Move> getMovesList() {
        return movesList;
    }

    public void setMovesList(List<Move> movesList) {
        this.movesList = movesList;
    }

    private  Game(Builder builder){
        this.playersList = builder.playersList;
        this.board = builder.board;
        this.winningStrategyList = builder.winningStrategyList;
        this.winner = builder.winner;
        this.movesList = builder.movesList;
        this.lastPlayerMovedIndex = builder.lastPlayerMovedIndex;
        this.gameStatus = builder.gameStatus;
    }

    public void makeMove() throws InvalidUndoOperation {
        lastPlayerMovedIndex++;
        System.out.println("playerlist.size-->"+this.playersList.size());
        Player player = playersList.get(lastPlayerMovedIndex % this.playersList.size());
// changing players between bot and human
        Move move = player.makeMove(board);
        if (Objects.isNull(move)){
            this.undo();
        }else {
            movesList.add(move);
            for (WinningStrategy winningStrategy: winningStrategyList){
                if (winningStrategy.checkIfWon(board, move.getCell(),player )){
                    setWinner(player);
                    setGameStatus(GameStatus.FINISHED);
                    break;
                }
            }
            // check if game has finished
            if (movesList.size() == board.getDimension() * board.getDimension()){
                setGameStatus(GameStatus.DRAW);
            }
        }
    }

    public void undo() throws InvalidUndoOperation {
        if (this.movesList.size()>1){
            Move move = this.movesList.get(this.movesList.size()-1);
            Cell cell = move.getCell();
            board.getCell(cell.getRow(), cell.getCol()).setSymbol(null);
            this.movesList.remove(this.movesList.size()-1);
        }else {
            throw new InvalidUndoOperation();
        }
    }

    /** Builder Class **/
    public static class Builder {
        private Board board;
        private List<Player> playersList;
        private List <WinningStrategy> winningStrategyList;
        private Player winner;
        private List<Move> movesList;
        private int lastPlayerMovedIndex;
        private GameStatus gameStatus;

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayersList(List<Player> playersList) {
            this.playersList = playersList;
            return this;
        }

        public Builder addPlayer (Player player){
            this.playersList.add(player);
            return this;
        }

        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Builder  setMovesList(List<Move> movesList) {
            this.movesList = movesList;
            return this;
        }

        public Builder setLastPlayerMovedIndex(int lastPlayerMovedIndex) {
            this.lastPlayerMovedIndex = lastPlayerMovedIndex;
            return this;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return  this;
        }

        public Game build() throws Exception {
            if (checkIfSingleBotMax()== false ){
                throw new MultipleBotException();
            }
            return new Game(this);
        }
        private boolean checkIfSingleBotMax() {
            if (playersList.stream().filter(player -> player.playerType.equals(PlayerType.BOT)).count() >1){
                return  false;
            }
            return true;
        }
    }
}
