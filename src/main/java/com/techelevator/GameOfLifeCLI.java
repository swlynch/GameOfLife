package com.techelevator;

import java.util.function.Function;

import com.techelevator.view.*;

public class GameOfLifeCLI {

	private static final String DISPLAY_GRID = "Display initial Game of Life board";
	private static final String EXIT = "Exit";
	private static final String[] NEXT_GRID = {"YES", "NO"};
	private static final String[] MAIN_OPTIONS = {DISPLAY_GRID, EXIT};
	
	private GameOfLifeGrid initialGrid;
	private GameOfLifeGrid nextGrid;
	private Menu menu;
	
	public GameOfLifeCLI(Menu menu, GameOfLifeGrid initialGrid) {
		this.menu = menu;
		this.initialGrid = initialGrid;
	}
	
	public void run() {
		while(true){
			String choice = (String)menu.getChoiceFromOptions(MAIN_OPTIONS);
			if(choice.equals(DISPLAY_GRID)) {
				setInitialGridData();
				System.out.println("\nINITIAL GRID: \n");
				printOutGameGrid(initialGrid);
				while(true) {
					System.out.println("Do you want to see the next state of grid?");
					String nextGridChoice = (String)menu.getChoiceFromOptions(NEXT_GRID);
					if (nextGridChoice.equals("YES")) {
						nextGrid = new GameOfLifeGrid();
						nextGrid = createNextStateOfGrid(initialGrid);
						System.out.println("\nNEXT STATE: \n");
						printOutGameGrid(nextGrid);
						
					} else {
						break;
					}
					initialGrid = nextGrid;
				}
			} else 
			break;
		}
		}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		GameOfLifeGrid initialGrid = new GameOfLifeGrid();
		GameOfLifeCLI cli = new GameOfLifeCLI(menu, initialGrid);
		cli.run();
	}
	
	public void setInitialGridData() {
		Boolean[][] array = {{false,false,false,false,false,false,true,false},
		        {true,true,true,false,false,false,true,false},
		        {false,false,false,false,false,false,true,false},
		        {false,false,false,false,false,false,false,false},
		        {false,false,false,true,true,false,false,false},
		        {false,false,false,true,true,false,false,false}};
		initialGrid.setGrid(array);
	}
	
	public GameOfLifeGrid getInitialGrid() {
		return initialGrid;
	}
	
	public void printOutGameGrid(GameOfLifeGrid grid) {
		Boolean[][] gridArray = grid.getGrid();
		for (int i = 0; i < gridArray.length; i++) {
			for (int k = 0; k < gridArray[i].length; k++) {
				System.out.print(displayLivingOrDead(gridArray[i][k]) + " ");
			}
			System.out.println("\n");
		}
	}
	
	public GameOfLifeGrid createNextStateOfGrid(GameOfLifeGrid initialGrid) {
		Boolean[][] nextGridArray = new Boolean[6][8];
		Boolean[][] initialGridArray = initialGrid.getGrid();
		for (int i = 0; i < initialGridArray.length; i++) {
			for (int k = 0; k < initialGridArray[i].length; k++) {
				nextGridArray[i][k] = initialGrid.shouldLive(i, k);
			}
		}
		nextGrid.setGrid(nextGridArray);
		return nextGrid;
	}
	
	private String displayLivingOrDead(Boolean bool) {
		if (bool) {
			return "O";
		} else {
			return ".";
		}
	}

	public void setNextGrid(GameOfLifeGrid nextGrid) {
		this.nextGrid = nextGrid;
	}
	
	public GameOfLifeGrid getNextGrid() {
		return nextGrid;
	}

	
}
