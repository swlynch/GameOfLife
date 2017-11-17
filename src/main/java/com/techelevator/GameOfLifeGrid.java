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

	public int countLivingCellsAboveAndBelow(int row, int column) {
		int livingCellsAboveBelowCells = 0;
		if (row > 0 && grid[row - 1][column]) {
			livingCellsAboveBelowCells++;
		}
		if (column < (grid.length - 1) && grid[row + 1][column]) {
			livingCellsAboveBelowCells++;
		}
		return livingCellsAboveBelowCells;
	}

	public int countLivingCellsOnDiagonals(int row, int column) {
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
	
	
	
	
}
