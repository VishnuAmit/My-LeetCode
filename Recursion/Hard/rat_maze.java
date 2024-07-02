// Problem link: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class Solution {
    // public static void solve(int[][] vis, int[][] m, int n,String s, List<String> ans, int i, int j){
    //     if(i==n-1 && j==n-1){
    //         ans.add(s);
    //         return;
    //     }
        
    //     //down
    //     if(i+1<n && m[i+1][j]==1 && vis[i+1][j]==0){
    //         vis[i][j]=1;
    //         solve(vis,m,n,s+"D",ans,i+1,j);
    //         vis[i][j]=0;
    //     }
    //     //up
    //     if(i-1>=0 && m[i-1][j]==1 && vis[i-1][j]==0){
    //         vis[i][j]=1;
    //         solve(vis,m,n,s+"U",ans,i-1,j);
    //         vis[i][j]=0;
    //     }
    //     // right
    //     if(j+1<n && m[i][j+1]==1 && vis[i][j+1]==0){
    //         vis[i][j]=1;
    //         solve(vis,m,n,s+"R",ans,i,j+1);
    //         vis[i][j]=0;
    //     }
    //     //left
    //     if(j-1>=0 && m[i][j-1]==1 && vis[i][j-1]==0){
    //         vis[i][j]=1;
    //         solve(vis,m,n,s+"L",ans,i,j-1);
    //         vis[i][j]=0;
    //     }
    // }
        
    private static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move,
        int vis[][], int di[], int dj[]) {
        if (i == n - 1 && j == n - 1) {
          ans.add(move);
          return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
          int nexti = i + di[ind];
          int nextj = j + dj[ind];
          if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
            vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {
    
            vis[i][j] = 1;
            solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
            vis[i][j] = 0;
    
          }
        }
      }
  
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Brute force - tc: O(4^(m*n)) sc: O(mxn)
        int[][] vis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=0;
            }
        }
        // ArrayList<String> ans=new ArrayList<>();
        // String s="";
        // if(m[0][0]==1){
        // solve(vis,m,n,s,ans,0,0);
        // }
        // return ans;
        
        
        // Optimal - tc: O(4^(m*n)) sc: O(mxn)
          int di[] = {
      +1,
      0,
      0,
      -1
    };
    int dj[] = {
      0,
      -1,
      1,
      0
    };
    ArrayList < String > ans = new ArrayList < > ();
    if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis, di, dj);
    return ans;
    }
}