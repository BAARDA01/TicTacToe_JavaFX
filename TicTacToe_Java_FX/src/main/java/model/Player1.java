package model;

public class Player1 {
    private char symbol;
    private boolean isHuman;

    public Player1(char symbol, boolean isHuman) {
        this.symbol = symbol;
        this.isHuman = isHuman;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

 public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    @Override
    public String toString() {
        return "Player: " + (isHuman ? "Human" : "Computer") + ", Symbol: " + symbol;
    }
}


