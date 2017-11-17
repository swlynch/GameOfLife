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
	
	@Test
	public void countLivingCellsNextToCellShouldReturn2() {
		Assert.assertEquals(2, gameGrid.countLivingCellsOnSides(1,1));
	}
	
	@Test
	public void countLivingCellsOnLeftEdgeColumnShouldReturn1() {
		Assert.assertEquals(1, gameGrid.countLivingCellsOnSides(4,3));
	}
	
	@Test
	public void countLivingCellsOnRightEdgeColumnShouldReturn0() {
		Assert.assertEquals(0, gameGrid.countLivingCellsOnSides(3, 7));
	}
	
	@Test
	public void countLivingCellsAboveAndBelowShouldReturn1() {
		Assert.assertEquals("Should return 1 for checking above and below cells at [2][2]", 1, gameGrid.countLivingCellsAboveAndBelow(2,2));
	}
	
	@Test
	public void countLivingCellsAboveAndBelowInTopRowShouldReturn1() {
		Assert.assertEquals("Should return 1 for checking above and below cells at [0][1]", 1, gameGrid.countLivingCellsAboveAndBelow(0,1));
	}
	
	@Test
	public void countLivingCellsAboveAndBelowInBottomRowShouldReturn0() {
		Assert.assertEquals("Should return 1 for checking above and below cells at [5][7]", 0, gameGrid.countLivingCellsAboveAndBelow(5,7));
	}
	
	@Test
	public void countLivingCellsOnDiagonalsShouldReturn1() {
		Assert.assertEquals("Should return for checking living cells at diagonals at [2][3]", 1, gameGrid.countLivingCellsOnDiagonals(2,3));
	}
	
	@Test
	public void countLivingCellsOnDiagonalInUpperLeftShouldReturn1() {
		Assert.assertEquals("Should return 1 for checking how many living diagonal cells at [0][0]", 1, gameGrid.countLivingCellsOnDiagonals(0, 0));
	}
	
	@Test
	public void countLivingCellsOnDiagonalInUpperRightShouldReturn1() {
		Assert.assertEquals("Should return 1 for checking how many living diagonal cells at [0][7]", 1, gameGrid.countLivingCellsOnDiagonals(0, 7));
	}
	
	@Test
	public void countLivingCellsOnDiagonalInBottomLeftShouldReturn0() {
		Assert.assertEquals("Should return 0 for checking how many living diagonal cells at [5][0]", 0, gameGrid.countLivingCellsOnDiagonals(5, 0));
	}
	
	@Test
	public void countLivingCellsOnDiagonalInBottomRightShouldReturn0() {
		Assert.assertEquals("Should return 0 for checking how many living diagonal cells at [5][7]", 0, gameGrid.countLivingCellsOnDiagonals(5, 7));
	}
	
	@Test
	public void countLivingCellsOnDiagonalInMiddleShouldReturn2() {
		Assert.assertEquals("Should return 2 for checking how many living diagonal cells at [1][5]", 2, gameGrid.countLivingCellsOnDiagonals(1,5));
	}
	
	@Test
	public void countAllSurroundingLivingCellsShouldReturn3() {
		Assert.assertEquals("Should return 3 for checking for all living cells at [1][5]", 3, gameGrid.countSurroundingLivingCells(1,5));
	}
	
}
