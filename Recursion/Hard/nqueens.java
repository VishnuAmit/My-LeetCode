// Problem link: https://leetcode.com/problems/n-queens/
class Solution {
    static List<String> construct(char[][] board){
        List<String> res=new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }

    // static boolean isSafe(int row, int col, char[][] board){
    //     int duprow=row;
    //     int dupcol=col;
    //     while(row>=0 && col>=0){
    //         if(board[row][col]=='Q') return false;
    //         row--;
    //         col--;
    //     }

    //     row=duprow;
    //     col=dupcol;
    //     while(col>=0){
    //         if(board[row][col]=='Q') return false;
    //         col--;
    //     }
        
    //     row=duprow;
    //     col=dupcol;
    //     while(row<board.length && col>=0){
    //         if(board[row][col]=='Q') return false;
    //         row++;
    //         col--;
    //     }
    //     return true;
    // }
    // static void solver(int col, char[][] board, List<List<String>> res){
    //     if(col==board.length){
    //         res.add(construct(board));
    //         return;
    //     }
    //     for(int row=0;row<board.length;row++){
    //         if(isSafe(row,col,board)){
    //             board[row][col]='Q';
    //             solver(col+1,board,res);
    //             board[row][col]='.';
    //         }
    //     }
    // }

    
    static void solver(int col, char[][] board, int[] leftrow, int[] lowerdiag, int[] upperdiag, List<List<String>> res){
        if(col==board.length){
            res.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(leftrow[row]==0 && lowerdiag[col+row]==0 && upperdiag[board.length-1+col-row]==0){
                board[row][col]='Q';
                leftrow[row]=1;
                lowerdiag[col+row]=1;
                upperdiag[board.length-1+col-row]=1;
                solver(col+1,board,leftrow,lowerdiag,upperdiag,res);
                board[row][col]='.';
                leftrow[row]=0;
                lowerdiag[col+row]=0;
                upperdiag[board.length-1+col-row]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        // // Brute force - tc: o(n!*n) sc: O(n2)
        // char[][] board=new char[n][n];
        // for (int i = 0; i < n; i++)
        //     for (int j = 0; j < n; j++)
        //         board[i][j] = '.';
        // List<List<String>> res=new ArrayList<List<String>>();
        // solver(0,board,res);
        // return res;

        // Optimal - tc: o(n!*n) sc: O(n)
        char[][] board=new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res=new ArrayList<List<String>>();
        int[] leftrow=new int[n];
        int[] lowerdiag=new int[2*n-1];
        int[] upperdiag=new int[2*n-1];
        solver(0,board,leftrow,lowerdiag,upperdiag,res);
        return res;
    }
}