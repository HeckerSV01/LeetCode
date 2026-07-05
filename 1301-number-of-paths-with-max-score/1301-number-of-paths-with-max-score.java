class Solution {
    final int mod=1000000007;
    private int[] solve(List<String> board, int i, int j, Integer dp1[][],Integer dp2[][]){
        if(i<0||i>=board.size()||j<0||j>=board.size()){
            return new int[]{Integer.MIN_VALUE,0};
        }
        char curr=board.get(i).charAt(j);
        if(curr=='X'){
            return new int[]{Integer.MIN_VALUE,0};
        }
        if(curr=='E'){
            return new int[]{0,1};
        }
        if(dp1[i][j]!=null&&dp2[i][j]!=null){
            return new int[]{dp1[i][j],dp2[i][j]};
        }
        int up[]=solve(board,i-1,j,dp1,dp2);
        int left[]=solve(board,i,j-1,dp1,dp2);
        int diag[]=solve(board,i-1,j-1,dp1,dp2);
        int bestscore=Math.max(up[0],Math.max(left[0],diag[0]));
        if(bestscore==Integer.MIN_VALUE){
            dp1[i][j]=Integer.MIN_VALUE;
            dp2[i][j]=0;
            return new int[]{Integer.MIN_VALUE,0};
        }
        int score=bestscore;
        int ways=0;
        if(curr!='S'){
            score=score+curr-'0';   
        }
        if(up[0]==bestscore){
            ways=(ways+up[1])%mod;
        }
        if(left[0]==bestscore){
            ways=(ways+left[1])%mod;
        }
        if(diag[0]==bestscore){
            ways=(ways+diag[1])%mod;
        }
        dp1[i][j]=score;
        dp2[i][j]=ways;
        return new int[]{score,ways};
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        Integer dp1[][]=new Integer[n][n];
        Integer dp2[][]=new Integer[n][n];
        int res[]=solve(board,n-1,n-1,dp1,dp2);
        if(res[0]==Integer.MIN_VALUE){
            return new int[]{0,0};
        }
        return res;
    }
}