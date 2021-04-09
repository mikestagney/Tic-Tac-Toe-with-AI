package tictactoe;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class HardComputerMove implements StrategyMove{

    final int PLAYER_PIECE = 20;
    final int OPPONENT_PIECE = -15;
    final int PLAYER_PIECES_4_WIN = 60;
    final int OPPONENT_PIECES_2_LOSE = -45;



    public Move makeMove(GameBoard gameboard, char piece) {
        System.out.println("Making move level \"hard\"");

        int[] board = createBoardArray(gameboard, piece);

        int bestMove = miniMaxFunction(board, OPPONENT_PIECE); // switch from player_piece to opponent_piece
        //System.out.println("The final best move is " + bestMove);
        int row = bestMove / 3;
        int col = bestMove % 3;

        return new Move(row, col, piece);
    }

    int miniMaxFunction(int[] newBoard, int pieceValue) {
        int[] availCellsIndexes = emptyIndexes(newBoard);
        //System.out.println(Arrays.toString(availCellsIndexes));
        if (checkWinner(newBoard, OPPONENT_PIECES_2_LOSE))
            return -10;
        else if (checkWinner(newBoard, PLAYER_PIECES_4_WIN))
            return 10;
        else if (availCellsIndexes.length == 0)
            return 0;

        Map<Integer, Integer> moves = new LinkedHashMap<>();


        // iterate through the map
        //int result = pieceValue == PLAYER_PIECE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i = 0; i < availCellsIndexes.length; i++) {
            int result;// = pieceValue == PLAYER_PIECE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // create object to store moves?
            int[] holdMove = new int[2];
            int index = newBoard[availCellsIndexes[i]];
            holdMove[0] = index;
            newBoard[availCellsIndexes[i]] = pieceValue;

            if (pieceValue == PLAYER_PIECE) {
                result = miniMaxFunction(newBoard, OPPONENT_PIECE);
                //holdMove[1] = result;
            } else {
                result = miniMaxFunction(newBoard, PLAYER_PIECE);
                //holdMove[1] = result;
            }
            holdMove[1] = result;
            newBoard[availCellsIndexes[i]] = index;
            moves.put(holdMove[0], holdMove[1]);
        }
        for (var entry : moves.entrySet()) {
            //System.out.println("index " + entry.getKey() + " value " + entry.getValue());
        }
        int bestMove = 0;
        if (pieceValue == PLAYER_PIECE) {
            int highestScore = Integer.MIN_VALUE;
            for (var move : moves.entrySet()) {
                if (move.getValue() > highestScore) {
                    highestScore = move.getValue();
                    bestMove = move.getKey();
                    //System.out.printf("Highest score %d with index %d%n", highestScore, bestMove);
                }
            }
        } else {
            int lowestScore = Integer.MAX_VALUE;
            for (var move : moves.entrySet()) {
                //System.out.println("move " + move.getKey() + " value " + move.getValue());
                if (move.getValue() < lowestScore) {
                    lowestScore = move.getValue();
                    bestMove = move.getKey();
                    //System.out.printf("Lowest score %d with index %d%n", lowestScore, bestMove);
                }
            }
            //System.out.println("end of map");
        }
        //System.out.println("best move is " + bestMove);
        return bestMove;
    }



    int[] createBoardArray(GameBoard gameBoard, char piece) {
        int[] board = new int[9];
        int indexCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.isCellFree(i, j)) {
                    board[indexCounter] = indexCounter;
                } else {
                    board[indexCounter] = gameBoard.getCell(i, j) == piece ? PLAYER_PIECE : OPPONENT_PIECE;
                }
                indexCounter++;
            }
        }
        return board;
    }
    int[] emptyIndexes(int[] board) {
        return Arrays.stream(board)
                .filter(i -> i != PLAYER_PIECE && i != OPPONENT_PIECE)
                .toArray();
    }
    boolean checkWinner(int[] board, int winningTotal) {
        for (int i = 0; i <= 6; i+=3) {
            if (board[i] + board[i + 1] + board[i + 2] == winningTotal) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] + board[i + 3] + board[i + 6] == winningTotal) return true;
            }
        return board[0] + board[4] + board[8] == winningTotal ||
                (board[6] + board[4] + board[2] == winningTotal);
    }
}
        /*
        boolean checkWinner(int[] board, int piece) {
        for (int i = 0; i < 3; i +=3) {
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2] && board[i + 2] == piece) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6] && board[i + 6] == piece) {
                return true;
            }
        }
        if ((board[0] == board[4] && board[4] == board[8] && board[8] == piece) ||
                ((board[6] == board[4] && board[4] == board[2] && board[2] == piece))) {
            return true;
        }
        return false;
    }*/