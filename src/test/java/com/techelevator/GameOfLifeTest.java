package com.techelevator;

import org.junit.*;

public class GameOfLifeTest {

	GameOfLifeGrid gameGrid;
	Boolean[][] grid;
	
	@Before
	public void setup() {
		gameGrid = new GameOfLifeGrid();
		Boolean[][] array = {{false,false,false,false,false,false,true,false},
		        {true,true,true,false,false,false,true,false},
		        {false,false,false,false,false,false,true,false},
		        {false,false,false,false,false,false,false,false},
		        {false,false,false,true,true,false,false,false},
		        {false,false,false,true,true,false,false,false}};
		gameGrid.setGrid(array);     
	}
	
	@Test
	public void shouldReturn6AsNumberOfRowsInGrid() {
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertEquals("Should return length of 6", 6, grid.length);
	}
	
	@Test
	public void shouldReturn8AsNumberOfColumnsInGrid() {
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertEquals("Should return size of row as 8", 8, grid[0].length);
	}
	
	@Test
	public void shouldReturnFalseToCheckCellStatus() {
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertFalse("Should return false for checking cell [0][0]", grid[0][0]);
	}
	
	@Test
	public void shouldReturnTrueToCheckCellStatus() {
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertTrue("Should return true for checking cell [0][6]", grid[0][6]);
	}
	
}
