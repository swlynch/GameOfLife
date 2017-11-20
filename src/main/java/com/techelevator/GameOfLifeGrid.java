package com.techelevator;

public class GameOfLifeGrid {

	public Boolean[][] grid;
	private int numberOfRows;
	private int numberOfColumns;
	

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
		if (!isInRightColumn(row, column) && grid[row][column + 1]) {
			livingNeighborCells++;
		}
		if (!isInLeftColumn(column) && grid[row][column - 1]) {
			livingNeighborCells++;
		}
		return livingNeighborCells;
	}

	public int livingCellsAboveAndBelow(int row, int column) {
		int livingCellsAboveBelowCells = 0;
		if (!isInTopRow(row) && grid[row - 1][column]) {
			livingCellsAboveBelowCells++;
		}
		if (!isInBottomRow(row) && grid[row + 1][column]) {
			livingCellsAboveBelowCells++;
		}
		return livingCellsAboveBelowCells;
	}

	public int livingCellsOnDiagonals(int row, int column) {
		int livingCellsOnDiagonals = 0;
		if (!isInTopRow(row) && !isInLeftColumn(column) && grid[row - 1][column - 1]) {
			livingCellsOnDiagonals++;
		}
		if (!isInTopRow(row) && !isInRightColumn(row, column) && grid[row - 1][column +1]) {
			livingCellsOnDiagonals++;
		}
		if (!isInBottomRow(row) && !isInLeftColumn(column) && grid[row + 1][column - 1]) {
			livingCellsOnDiagonals++;
		}
		if (!isInBottomRow(row) && !isInRightColumn(row, column) && grid[row + 1][column + 1]) {
			livingCellsOnDiagonals++;
		}
		return livingCellsOnDiagonals;
	}

	public boolean isInTopRow(int row) {
		return row == 0;
	}
	
	public boolean isInLeftColumn(int column) {
		return column == 0;
	}
	
	public boolean isInRightColumn(int row, int column) {
		return (column == grid[row].length - 1);
	}
	
	public boolean isInBottomRow(int row) {
		return (row == (grid.length - 1));
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

	public void setNumberOfRows(int rows) {
		this.numberOfRows = rows;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfColumn(int columns) {
		this.numberOfColumns = columns;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setGridDimensions(int rows, int columns) {
	}
	
	
	
	
}
