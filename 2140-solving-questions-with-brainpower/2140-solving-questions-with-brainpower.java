class Solution {
    public long mostPoints(int[][] questions) {
        int m = questions.length;
        long dp[] = new long[m+1];
        dp[m-1]=(long)questions[m-1][0];
        for(int i=m-1;i>=0;i--){
            long skip=dp[i+1];
            int nxt=i+questions[i][1]+1;
            long k=0;
            if(nxt>m){
                k=0;
            }else{
                k=dp[nxt];
            }
            long notskip=questions[i][0]+k;
            dp[i]=Math.max(skip,notskip);
        }
        return dp[0];
    }
}