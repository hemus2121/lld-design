package org.scaler.ttt.exceptions;

import org.scaler.ttt.models.Game;

public class MultipleBotException extends Exception {

    public MultipleBotException()  {
        super("A game cannot have more than one bot players.");
    }
}
