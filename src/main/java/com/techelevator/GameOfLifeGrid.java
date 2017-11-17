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

	public int livingCellsOnSides(int row, int column) {
		int livingNeighborCells = 0;
		if (column < (grid[row].length - 1) && grid[row][column + 1]) {
			livingNeighborCells++;
		}
		if (column > 0 && grid[row][column - 1]) {
			livingNeighborCells++;
		}
		return livingNeighborCells;
	}

	public int livingCellsAboveAndBelow(int row, int column) {
		int livingCellsAboveBelowCells = 0;
		if (row > 0 && grid[row - 1][column]) {
			livingCellsAboveBelowCells++;
		}
		if (row < (grid.length - 1) && grid[row + 1][column]) {
			livingCellsAboveBelowCells++;
		}
		return livingCellsAboveBelowCells;
	}

	public int livingCellsOnDiagonals(int row, int column) {
		int livingCellsOnDiagonals = 0;
		if (row > 0 && column > 0 && grid[row - 1][column - 1]) {
			livingCellsOnDiagonals++;
		}
		if (row > 0 && column < (grid[row].length - 1) && grid[row - 1][column +1]) {
			livingCellsOnDiagonals++;
		}
		if (row < (grid.length - 1) && column > 0 && grid[row + 1][column - 1]) {
			livingCellsOnDiagonals++;
		}
		if (row < (grid.length - 1) && column < (grid[row].length - 1) && grid[row + 1][column + 1]) {
			livingCellsOnDiagonals++;
		}
		return livingCellsOnDiagonals;
	}

	public int countSurroundingLivingCells(int row, int column) {
		return livingCellsOnSides(row,column) + 
				livingCellsAboveAndBelow(row,column) + 
				livingCellsOnDiagonals(row,column);
	}

	public boolean shouldLive(int row, int column) {
		if (grid[row][column] && 
			(countSurroundingLivingCells(row,column) == 2) || 
				(countSurroundingLivingCells(row,column) == 3)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
