package model;

import java.util.Scanner;

public class GameController {
    private Game game;
    private Scanner scanner;

    public GameController(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    public void startGame() {
        game.startGame();
    }

    public void makeMove(int row, int col) {
        game.makeMove(row, col, null);
    }

    public void makeRandomMove() {
        game.makeRandomMove();
    }

    public void switchPlayer() {
        game.switchPlayer();
    }

    public boolean isGameOver() {
        return game.isGameOver();
    }

    public boolean isDraw() {
        return game.isDraw();
    }

    public void resetGame() {
        game.resetGame();
    }

    public void printBoard() {
        game.printBoard();
    }

    public void readUserInput() {
        System.out.print("Enter row and column (e.g. 1 2): ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);
        makeMove(row, col);
    }
}

