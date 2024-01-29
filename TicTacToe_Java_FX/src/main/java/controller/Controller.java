package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Board;
import model.Game;
import model.GameController;
import model.GameStatusEnum;
import model.Move;
import model.Player1;
import model.Player2;
import model.SelectPlayer;
import model.SymbolEnum;



public class Controller extends Application {
    private char currentPlayer = 'X';
    private char winner = ' ';
    private GridPane grid;
    private Label playerLabel;
    private Board board;
    private Game game;
    private GameController gameController;
    private Move move;
    private SelectPlayer player;
    private Player1 player1;
    private Player2 player2;
    private SymbolEnum symbolEnum;
    private GameStatusEnum gameStatusEnum;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	
        grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);   
       
      

        playerLabel = new Label("Player: ");
        playerLabel.setAlignment(Pos.CENTER);
        playerLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        grid.add(playerLabel, 0, 0);
        
        
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> resetGame());
        grid.add(resetButton, 0, 4);
        resetButton.setMinSize(50, 50);
        resetButton.setAlignment(Pos.BASELINE_RIGHT);
        
        
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(200, 200);
                button.setOnAction(event -> {
                    if ("".equals(button.getText())) {
                        button.setText(String.valueOf(currentPlayer));

                        if (currentPlayer == 'X') {
                            currentPlayer = 'O';
                        } else {
                            currentPlayer = 'X';
                        }

                        checkWinner();
                    }
                });

                grid.add(button, j, i + 1);
            }
        }

        Scene scene = new Scene(grid, 900, 900);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    

    public char getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(char currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public char getWinner() {
		return winner;
	}

	public void setWinner(char winner) {
		this.winner = winner;
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public Label getPlayerLabel() {
		return playerLabel;
	}

	public void setPlayerLabel(Label playerLabel) {
		this.playerLabel = playerLabel;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public SelectPlayer getPlayer() {
		return player;
	}

	public void setPlayer(SelectPlayer player) {
		this.player = player;
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

	public SymbolEnum getSymbolEnum() {
		return symbolEnum;
	}

	public void setSymbolEnum(SymbolEnum symbolEnum) {
		this.symbolEnum = symbolEnum;
	}

	public GameStatusEnum getGameStatusEnum() {
		return gameStatusEnum;
	}

	public void setGameStatusEnum(GameStatusEnum gameStatusEnum) {
		this.gameStatusEnum = gameStatusEnum;
	}

	private void checkWinner() {
       
        for (int i = 0; i < 3; i++) {
            if (checkLine(i, 0, 0, 1)) {
                winner = currentPlayer;
                break;
            }
        }

        
        for (int i = 0; i < 3; i++) {
            if (checkLine(0, i, 1, 0)) {
                winner = currentPlayer;
                break;
            }
        }

    
        if (checkLine(0, 0, 1, 1) || checkLine(0, 2, 1, -1)) {
            winner = currentPlayer;
        }

     
        if (winner != ' ') {
            playerLabel.setText("Winner: " + winner);
        }
    }

    private boolean checkLine(int startRow, int startCol, int rowStep, int colStep) {
        Node node = grid.getChildren().get(startRow * 3 + startCol);
        if (!(node instanceof Button)) {
            return false;
        }

        String first = ((Button) node).getText();
        if (first.isEmpty()) {
            return false;
        }

        for (int i = 1; i < 3; i++) {
            node = grid.getChildren().get((startRow + i * rowStep) * 3 + startCol + i * colStep);
            if (!(node instanceof Button)) {
                return false;
            }

            String next = ((Button) node).getText();
            if (!first.equals(next)) {
                return false;
            }
        }

        return true;
    }
    
    private void resetGame() {

        currentPlayer = 'X';
        winner = ' ';

        for (Node node : grid.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setText("");
            }
        }

        playerLabel.setText("Player: ");
    }
}


