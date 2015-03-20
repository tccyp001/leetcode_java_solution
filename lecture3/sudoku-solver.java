public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuDFS(board);
    }
    public boolean solveSudokuDFS(char[][] board) {
        
        for(int i = 0;i<board.length;i++) {
            for(int j = 0;j<board[0].length;j++) {
                if(board[i][j] == '.') {
                    for(int k = 1;k<=9;k++) {
                        board[i][j] = (char)('0' +k);
                        if(isValid(board,i,j)&&solveSudokuDFS(board))return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int i,int j) {
        char c = board[i][j];
        
        int colStart = j/3 *3;
        int rowStart = i/3*3;
        for(int h = rowStart;h<rowStart+3;h++) {
            for(int k = colStart;k<colStart+3;k++) {
                 if(h!=i && k!=j&&board[h][k]==c)return false;
            }
        }
        
        for(int h =0;h<9;h++) {
            if(h!=j&&board[i][h] ==c)return false;
            if(h!=i&&board[h][j] ==c)return false;
        }
        return true;
    }
}