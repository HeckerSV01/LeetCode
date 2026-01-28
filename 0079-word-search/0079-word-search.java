class Solution {
    boolean res=false;
    final int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
    private boolean dfs(char a[][], String s, int i, int j, int idx, int m, int n,boolean vis[][]){
        if(vis[i][j]||s.charAt(idx)!=a[i][j]){
            return false;
        }
        if(idx==s.length()-1){
            return true;
        }
        vis[i][j]=true;
        boolean res=false;
        for(int k=0;k<4;k++){
            int nr=i+dir[k][0];
            int nc=j+dir[k][1];
            if(nr>=0&&nr<m&&nc>=0&&nc<n&&s.charAt(idx+1)==a[nr][nc]){
                res=res||dfs(a,s,nr,nc,idx+1,m,n,vis);
            }
        }
        vis[i][j]=false;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0,m,n,vis)){
                        return true;
                    } 
                }
            }
        }
        return false;
    }
}