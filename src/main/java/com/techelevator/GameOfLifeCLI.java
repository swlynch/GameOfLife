package com.techelevator;

import java.util.Scanner;
import java.util.function.Function;

import com.techelevator.view.*;

public class GameOfLifeCLI {

	private static final String DISPLAY_GRID = "Display initial Game of Life grid";
	private static final String SET_DIMENSIONS = "Change dimensions of grid";
	private static final String CREATE_INITIAL_DATA = "Create your own starting grid";
	private static final String EXIT = "Exit";
	private static final String[] NEXT_GRID = {"YES", "NO"};
	private static final String[] MAIN_OPTIONS = {DISPLAY_GRID, SET_DIMENSIONS, CREATE_INITIAL_DATA ,EXIT};
	private static final String BANNER = "*** CONWAY'S GAME OF LIFE DEMO ***";
	private static final String SIGN_OFF = "\nthank you for observing the beauty and complexity of life forms.";
	
	private GameOfLifeGrid initialGrid;
	private GameOfLifeGrid nextGrid;
	private Menu menu;
	private Scanner userInput = new Scanner(System.in);
	
	public GameOfLifeCLI(Menu menu, GameOfLifeGrid initialGrid) {
		this.menu = menu;
		this.initialGrid = initialGrid;
	}
	
	public void run() {
		System.out.println(BANNER);
		while(true){
			String choice = (String)menu.getChoiceFromOptions(MAIN_OPTIONS);
			if(choice.equals(DISPLAY_GRID)) {
				setSampleGridData();
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
			} else if (choice.equals(SET_DIMENSIONS)) {
				boolean validRows = false;
				boolean validColumns = false;
				int rows = 0;
				int columns = 0;
				while(!validRows) {
					System.out.println("\nSet Grid Dimensions:\n" + 
										"How many rows? ");
					rows = userInput.nextInt();
					if (rows > 0) {
						validRows = true;
					}
				} 
				while(!validColumns) {
					System.out.println("How many columns? ");
					columns = userInput.nextInt();
					if (columns > 0 ) {
						validColumns = true;
					}
				}
				initialGrid.setGridDimensions(rows, columns);
			} else if (choice.equals(CREATE_INITIAL_DATA)) {
				
			} else {
				System.out.println(SIGN_OFF);
				break;
			}

		}
		}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		GameOfLifeGrid initialGrid = new GameOfLifeGrid();
		GameOfLifeCLI cli = new GameOfLifeCLI(menu, initialGrid);
		cli.run();
	}
	
	public void setSampleGridData() {
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
