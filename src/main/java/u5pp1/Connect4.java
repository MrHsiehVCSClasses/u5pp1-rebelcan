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

public static boolean isBoardValid(int[][] board){
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            if (board[i][j] == 0 && (board[i][j+1] == 1 || board[i][j+1] == -1)){
                return true;
            }
        }
    }
    return false;
}

public static int getWinner(int[][] board){

}
   // It is recommended to use private helper methods

}
