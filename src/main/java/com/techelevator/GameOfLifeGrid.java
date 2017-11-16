package com.techelevator;

public class GameOfLifeGrid {

	public Boolean[][] grid;

	public GameOfLifeGrid() {
		this.grid = new Boolean[6][8]; 
	}
	
	public Boolean[][] getGrid() {
		return grid;
	}
	
}
