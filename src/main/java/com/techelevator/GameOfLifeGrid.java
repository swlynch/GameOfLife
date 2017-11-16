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
		if (column < (grid[row].length - 1) && grid[row][column + 1]) {
			livingNeighborCells++;
		}
		if (column > 0 && grid[row][column - 1]) {
			livingNeighborCells++;
		}
		return livingNeighborCells;
	}
	
	
	
	
}
