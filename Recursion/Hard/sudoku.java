// Problem link: https://leetcode.com/problems/sudoku-solver/
class Solution {
    public boolean isvalid(char[][] board, int row, int col, char c){
        for(int i=0; i<9; i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }

    public boolean solver(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char c='1'; c<='9'; c++){
                        if(isvalid(board, i, j, c)){
                            board[i][j] = c;
                            if(solver(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
            // tc: O(9^(n ^ 2)) sc: O(1)
        solver(board);
    }
}

