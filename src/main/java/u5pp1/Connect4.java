package u5pp1;

public class Connect4 {

    public static final int RED_WIN = 0;
    public static final int BLACK_WIN = 1;
    public static final int NO_WINNER = 2;
    public static final int BOTH_WIN = 3;

    public static final int RED = 1;
    public static final int BLACK = -1;
    public static final int EMPTY = 0;

   // implementation here
public static boolean isFull(int[][] board){
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            if (board[i][j] == 0){
                return false;
            }
            // if (board[i][j] == 0){
            //     return false;
            // }
        }
    }
    return true;
}

// public static boolean isBoardValid(int[][] board){
//     for (int i=0; i<6; i++){
//         for (int j=0; j<7; j++){
//             if (board[i][j] == 0 && (board[i][j+1] == 1 || board[i][j+1] == -1)){
//                 return true;
//             }
//         }
//     }
//     return false;
// }
public static boolean isBoardValid(int[][] board){
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != 0) { // check only non-empty cells
    // check if this cell has a neighbor in each of the four directions
            if ((i > 0 && board[i-1][j] == 0) || (i < board.length-1 && board[i+1][j] == 0) || (j > 0 && board[i][j-1] == 0) || (j < board[0].length-1 && board[i][j+1] == 0)) {
                return false; // found a floating piece, return false
            }
            }
        }
    }
    return true; // no floating pieces found, return true
    }

    public static int getWinner(int[][] board) {
        boolean redConnected = false;
        boolean blackConnected = false;
        boolean hasEmptyCell = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    hasEmptyCell = true;
                } else {
                    // check if there is a horizontal win
                    if (j <= board[0].length - 4 && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3]) {
                        if (board[i][j] == 1) {
                            redConnected = true;
                        } else {
                            blackConnected = true;
                        }
                    }
                    // check if there is a vertical win
                    if (i <= board.length - 4 && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j]) {
                        if (board[i][j] == 1) {
                            redConnected = true;
                        } else {
                            blackConnected = true;
                        }
                    }
                    // check if there is a diagonal win 
                    if (i <= board.length - 4 && j <= board[0].length - 4 && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3]) {
                        if (board[i][j] == 1) {
                            redConnected = true;
                        } else {
                            blackConnected = true;
                        }
                    }
                    // check if there is a diagonal win 
                    if (i >= 3 && j <= board[0].length - 4 && board[i][j] == board[i-1][j+1] && board[i][j] == board[i-2][j+2] && board[i][j] == board[i-3][j+3]) {
                        if (board[i][j] == 1) {
                            redConnected = true;
                        } else {
                            blackConnected = true;
                        }
                    }
                }
            }
        }
        if (redConnected && blackConnected) {
            return BOTH_WIN;
        } else if (redConnected) {
            return RED_WIN;
        } else if (blackConnected) {
            return BLACK_WIN;
        } else if (hasEmptyCell) {
            return NO_WINNER;
        } else {
            return BOTH_WIN;
        }
    }
   // It is recommended to use private helper methods

}
