package com.techelevator;

import org.junit.*;

public class GameOfLifeTest {

	
	@Before
	public void setup() {
	}
	
	@Test
	public void shouldReturnLengthOf8() {
		GameOfLifeGrid gameGrid = new GameOfLifeGrid();
		Boolean[][] grid = gameGrid.getGrid();
		Assert.assertEquals("Should return length of 8", grid.length);
	}
}
