## Conway's Game Of Life
This code runs a demonstration of Conway's Game of Life, a cellular automation developed by John Horton Conway in 1970. Rules about the algorithm can be found [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Rules).


__Building__

If you have Maven installed, you can run the unit tests by running the command:
```
mvn test
```

Or you can run the application by running the commands: 
```
mvn install
java -cp target/GameOfLife-0.0.1-SNAPSHOT.jar com.techelevator.GameOfLifeCLI 
```

__Functionality__

Upon running the program, the CLI will prompt you with three options: 

1. Set Dimensions of Grid
2. Run Game of Life Demonstration
3. Exit


_Set Dimensions of Grid_

User can set a certain number of rows and columns for the Game of Life grid. User is prompted to re-enter a number if a non-integer or the number 0 is entered. The user inputs set the size of the Game of Life grid used in the demonstration.

_Run Game of Life Demonstration_

Generates an initial game board based on the dimensions the user has set in the first main menu option and a randomized state of living or dead for each cell in the grid. Living cells are represented as "O" and dead cells are represented as "."

If the user hasn't set their own dimensions, a pre-set 6x8 grid is provided and printed. 

After the initial grid is printed to screen, the user is asked if they want to see the next state of the grid. If they choose yes, another grid is generated and printed, using the [rules of the automation](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Rules). The user can continue to generate as many new states until they choose "No" and are taken to the main menu.

_Exit_

User exits the program.
