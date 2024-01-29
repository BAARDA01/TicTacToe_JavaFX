package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Board board;
    private Player1 player1;
    private Player2 player2;
    private SelectPlayer selectPlayer;
    private GameStatusEnum gameStatus;
    private SymbolEnum currentSymbol;
    private int currentPlayer;
    private List<Move> moves = new ArrayList<>();

    public Game(Board board, Player1 player1, Player2 player2, SelectPlayer selectPlayer) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.selectPlayer = selectPlayer;
        this.gameStatus = GameStatusEnum.IN_PROGRESS;
        this.currentSymbol = SymbolEnum.X;
        this.currentPlayer = 1;
    }

    public void makeMove(int row, int col, SymbolEnum symbolEnum) {
        if (board.isValidMove(row, col)) {
            moves.add(new Move(row, col));
            board.makeMove(row, col, currentSymbol);
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
            currentSymbol = (currentSymbol == SymbolEnum.X) ? SymbolEnum.O : SymbolEnum.X;
            gameStatus = board.getGameStatus();
        }
    }

    public GameStatusEnum getGameStatus() {
        return gameStatus;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void startGame() {
        gameStatus = GameStatusEnum.IN_PROGRESS;
        currentPlayer = 1;
        currentSymbol = SymbolEnum.X;
        board.clearBoard();
    }

    public void makeRandomMove() {
        int row = new Random().nextInt(3) + 1;
        int col = new Random().nextInt(3) + 1;
        makeMove(row, col, currentSymbol);
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
        currentSymbol = (currentSymbol == SymbolEnum.X) ? SymbolEnum.O : SymbolEnum.X;
    }

    public boolean isGameOver() {
        return gameStatus == GameStatusEnum.GAME_OVER;
    }

    public boolean isDraw() {
        return gameStatus == GameStatusEnum.DRAW;
    }

    public void resetGame() {
        gameStatus = GameStatusEnum.IN_PROGRESS;
        currentPlayer = 1;
        currentSymbol = SymbolEnum.X;
        board.clearBoard();
    }

    public List<Move> getMoves() {
        return moves;
    }

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player1 getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player1 player1) {
		this.player1 = player1;
	}

	public Player2 getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player2 player2) {
		this.player2 = player2;
	}

	public SelectPlayer getSelectPlayer() {
		return selectPlayer;
	}

	public void setSelectPlayer(SelectPlayer selectPlayer) {
		this.selectPlayer = selectPlayer;
	}

	public SymbolEnum getCurrentSymbol() {
		return currentSymbol;
	}

	public void setCurrentSymbol(SymbolEnum currentSymbol) {
		this.currentSymbol = currentSymbol;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setGameStatus(GameStatusEnum gameStatus) {
		this.gameStatus = gameStatus;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

  
}





