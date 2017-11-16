package com.techelevator;

import org.junit.*;

public class GameOfLifeTest {

	
	@Before
	public void setup() {
	}
	
	@Test
	public void shouldReturnLengthOf6() {
		GameOfLifeGrid gameGrid = new GameOfLifeGrid();
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertEquals("Should return length of 6", 6, grid.length);
	}
}
