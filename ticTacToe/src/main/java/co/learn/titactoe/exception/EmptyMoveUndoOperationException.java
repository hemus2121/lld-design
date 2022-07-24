package co.learn.titactoe.exception;

public class EmptyMoveUndoOperationException  extends  Exception{

    public EmptyMoveUndoOperationException(){
        super("Undo Operation no supported when no move is present ");
    }
}
