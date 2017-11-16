package com.techelevator;

import org.junit.*;

public class GameOfLifeTest {

	
	@Before
	public void setup() {
	}
	
	@Test
	public void shouldReturn6AsNumberOfRowsInGrid() {
		GameOfLifeGrid gameGrid = new GameOfLifeGrid();
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertEquals("Should return length of 6", 6, grid.length);
	}
	
	@Test
	public void shouldReturn8AsNumberOfColumnsInGrid() {
		GameOfLifeGrid gameGrid = new GameOfLifeGrid();
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertEquals("Should return size of row as 8", 8, grid[0].length);
	}
}
