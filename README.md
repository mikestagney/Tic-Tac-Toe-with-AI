# Tic-Tac-Toe with AI

Command line Tic Tac Toe game for 0, 1 or 2 human players with 3 levels of AI.

## Things learned

Used regex to validate user input.

Strategy and Factory design patterns used.

Planning and organizing complex application (uses 12 java class files).

### Details

Project created for JetBrains Academy Java Developer course - medium level project.

Almost complete, hard AI using minimax algorithm is not working correctly.

Easy AI selects a random open cell.  Medium AI selects a random cell unless there is a cell that will either win for the computer or block the opponent from winning.

#### The directory contains 12 files: 

* Main.java - sets up game and runs the game loop
* GameBoard.java - maintains the game board, processes moves, checks for win, draw and free cells
* Move.java - class that encapsulates data needed for a player's move
* Player.java - abstract class, parent of HumanPlayer and ComputerPlayer classes
* ComputerPlayer.java - class for computer player objects
* HumanPlayer.java - class for human player objects
* PlayerFactory.java - class uses factory pattern to build player objects and the strategy pattern to assign the appropriate algorithm to them 
* StrategyMove.java - interface for all computer and human move algorithms
* EasyComputerMove.java - the class with the algorithm for easy computer AI
* MediumComputerMove.java - the class with the algorithm for medium computer AI
* HardComputerMove.java - the class with the algorithm for hard computer AI
* HumanMove.java - the class that handles human player movement

### How to play

To start the game, use the **start** command. It takes two parameters: who wil play X and who will play O. For human players, **user** to play and **easy**, **medium** or **hard** to play as an AI.  Any combination of these parameters will work. First parameter plays X and second plays O.

One the game starts, select cell by keying two numbers. The top-left cell will have the coordinates (1, 1) and the bottom-right cell will have the coordinates (3, 3), as shown in this table:

|        |        |        |
|:------:|:------:|:------:|
| (1, 1) | (1, 2) | (1, 3) |
| (2, 1) | (2, 2) | (2, 3) |
| (3, 1) | (3, 2) | (3, 3) |

### Sample input and output:

Input command:  start hard user

Making move level "hard"\
--------\
| &emsp; &emsp; &emsp; |\
| X &emsp; &emsp;         |\
| &emsp; &emsp; &emsp; |\
---------\
Enter the coordinates: > 2 2\
---------\
| &emsp; &emsp; &emsp;|\
| X O &emsp;              |\
| &emsp; &emsp; &emsp;|\
---------\
Making move level "hard"\
---------\
| &emsp;  X &emsp;|\
| X O &emsp;  |\
| &emsp; &emsp; &emsp;|\
---------\
Enter the coordinates: > 3 2\
---------\
| &emsp; X &emsp;  |\
| X O &emsp;          |\
| &emsp; O &emsp;  |\
---------\
Making move level "hard"\
---------\
| X X &emsp;  |\
| X O &emsp;  |\
| &emsp;  O &emsp;|\
---------\
Enter the coordinates: > 3 1\
---------\
| X X &emsp;  |\
| X O &emsp;  |\
| O O &emsp;  |\
---------\
Making move level "hard"\
---------\
| X X X |\
| X O &emsp;|\
| O O &emsp;|\
---------\
X wins

Input command: > exit
