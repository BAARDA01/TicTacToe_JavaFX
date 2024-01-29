package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<String>> board;
    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            board.add(row);
        }
    }

    public void setCell(int row, int col, String value) {
        board.get(row).set(col, value);
    }

    public String getCell(int row, int col) {
        return board.get(row).get(col);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (List<String> row : board) {
            result.append("| ");
            for (String cell : row) {
                result.append(cell).append(" ");
            }
            result.append("|\n");
        }
        return result.toString();
    }

    public boolean isValidMove(int row, int col) {
      
        if (getCell(row, col).isEmpty()) {
            return true;
        }
       
        for (SymbolEnum symbol : SymbolEnum.values()) {
            if (getCell(row, col).equals(symbol.toString())) {
                return false;
            }
        }
        return false;
    }

    public void makeMove(int row, int col, SymbolEnum currentSymbol) {
       
        if (isValidMove(row, col)) {
            setCell(row, col, currentSymbol.toString());
        }
    }

    public void printBoard() {
        System.out.println(this.toString());
    }

    public int getSize() {
        return rows * cols;
    }

    public GameStatusEnum getGameStatus() {
       
        for (int i = 0; i < rows; i++) {
            if (!getCell(i, 0).isEmpty() && getCell(i, 0).equals(getCell(i, 1)) && getCell(i, 1).equals(getCell(i, 2))) {
                return GameStatusEnum.WIN;
            }
        }
    
        for (int i = 0; i < cols; i++) {
            if (!getCell(0, i).isEmpty() && getCell(0, i).equals(getCell(1, i)) && getCell(1, i).equals(getCell(2, i))) {
                return GameStatusEnum.WIN;
            }
        }
   
        if (!getCell(0, 0).isEmpty() && getCell(0, 0).equals(getCell(1, 1)) && getCell(1, 1).equals(getCell(2, 2))) {
            return GameStatusEnum.WIN;
        }
        if (!getCell(0, 2).isEmpty() && getCell(0, 2).equals(getCell(1, 1)) && getCell(1, 1).equals(getCell(2, 0))) {
            return GameStatusEnum.WIN;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getCell(i, j).isEmpty()) {
                    return GameStatusEnum.IN_PROGRESS;
                }
            }
        }
       
        return GameStatusEnum.DRAW;
    }


    public List<List<String>> getBoard() {
		return board;
	}

	public void setBoard(List<List<String>> board) {
		this.board = board;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public void clearBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                setCell(i, j, "");
            }
        }
    }

}


   


