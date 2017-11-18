package com.techelevator;

import com.techelevator.view.*;

public class GameOfLifeCLI {

	private static final String[] MAIN_OPTIONS = {"Display initial Game of Life board"};
	private static final String DISPLAY_GRID = "Display initial Game of Life board";
	
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
				display(initialGrid);
				
			}
		}
		}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		GameOfLifeGrid initialGrid = new GameOfLifeGrid();
		GameOfLifeCLI cli = new GameOfLifeCLI(menu, initialGrid);
		cli.setInitialGridData();
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
	
	public void display(GameOfLifeGrid grid) {
		System.out.println("Hi!");
	}
	
}
