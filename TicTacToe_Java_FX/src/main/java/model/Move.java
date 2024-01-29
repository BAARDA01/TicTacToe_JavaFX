package model;


	public class Move {
	    int row;
	    int col;

	    public Move(int row, int col) {
	        this.row = row;
	        this.col = col;
	    }

	    public int getRow() {
	        return row;
	    }

	    public int getCol() {
	        return col;
	    }

	    @Override
	    public String toString() {
	        return "Move(" + row + ", " + col + ")";
	    }
	}


