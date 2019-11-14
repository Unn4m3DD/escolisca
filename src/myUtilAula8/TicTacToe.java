package myUtilAula8;

public class TicTacToe {
    int[][] board = new int[3][3];
    boolean c_player = true;
    public String click(int i, int j){
        board[i][j] = c_player ? 1 : 2;
        c_player = !c_player;
        return c_player ? "x" : "o";
    }

    public String testWin(){
        if(     (board[0][0]!=0 && board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
                (board[1][0]!=0 && board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
                (board[2][0]!=0 && board[2][0] == board[2][1] && board[2][1] == board[2][2]) ||
                (board[0][0]!=0 && board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
                (board[0][1]!=0 && board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                (board[0][2]!=0 && board[0][2] == board[1][2] && board[1][2] == board[2][2]) ||
                (board[0][0]!=0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[2][0]!=0 && board[2][0] == board[1][1] && board[1][1] == board[0][2])
                ) return c_player ? "x" : "o";
        return "";
    }
}
