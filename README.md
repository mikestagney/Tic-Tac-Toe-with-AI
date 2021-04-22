# Tic-Tac-Toe-with-AI.  Written in **Java.**

Command line Tic Tac Toe game for 0, 1 or 2 human players with 3 levels of AI.

## Things learned

Used regex to validate user input.

Strategy and Factory design patterns used.

Planning and organizing complex application (uses 12 java class files).

### Details

Project created for JetBrains Academy Java Developer course - medium level project.

Almost complete, hard AI using minimax algorithm is not working correctly.

Easy AI selects a random open cell.  Medium AI selects a random cell unless there is a cell that will either win for the computer or block the opponent from winning.

### How to play

To start the game, use the **start** command. It takes two parameters: who wil play X and who will play O. For human players, **user** to play and **easy**, **medium** or **hard** to play as an AI.  Any combination of these parameters will work. First parameters plays X and second plays O.

One the game starts, select cell by keying two numbers. The top-left cell will have the coordinates (1, 1) and the bottom-right cell will have the coordinates (3, 3), as shown in this table:

|        |        |        |
|:------:|:------:|:------:|
| (1, 1) | (1, 2) | (1, 3) |
| (2, 1) | (2, 2) | (2, 3) |
| (3, 1) | (3, 2) | (3, 3) |

### Path to the source files:

https://github.com/mikestagney/Tic-Tac-Toe-with-AI/tree/master/Tic-Tac-Toe%20with%20AI/task/src/tictactoe

