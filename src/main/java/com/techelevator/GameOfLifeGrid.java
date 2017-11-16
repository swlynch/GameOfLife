package com.techelevator;

public class GameOfLifeGrid {

	public Boolean[][] grid;

	public GameOfLifeGrid() {
	}
	
	public void setGrid(Boolean[][] grid) {
		this.grid = grid;
	}
	
	public Boolean[][] getGrid() {
		return grid;
	}

	public int countLivingCellsOnSides(int row, int column) {
		int livingNeighborCells = 0;
		if (grid[row][column + 1] && column <= grid[row].length) {
			livingNeighborCells++;
		}
		if (grid[row][column - 1] && column >= 0) {
			livingNeighborCells++;
		}
		return livingNeighborCells;
	}
	
	
	
	
}
