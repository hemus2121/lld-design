package co.learn.titactoe.models;

public class Symbol {

    public Symbol(char c){
        this.character = c;
    }
    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    private char character;
}
