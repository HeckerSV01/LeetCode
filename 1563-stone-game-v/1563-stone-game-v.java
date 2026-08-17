class Solution {
    private int solve(int pref[],int i,int j,Integer dp[][]){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int res=0;
        for(int k=i;k<j;k++){
            int sum1=pref[k];
            int sum2=pref[j]-pref[k];
            if(i>0){
                sum1=sum1-pref[i-1];
            }
            if(sum1>sum2){
                res=Math.max(res,sum2+solve(pref,k+1,j,dp));
            }else if(sum1<sum2){
                res=Math.max(res,sum1+solve(pref,i,k,dp));
            }else{
                res=Math.max(res,Math.max(sum1+solve(pref,i,k,dp),sum2+solve(pref,k+1,j,dp)));
            }
        }
        return dp[i][j]=res;
    }
    public int stoneGameV(int[] stoneValue) {
        int pref[]=new int[stoneValue.length];
        pref[0]=stoneValue[0];
        for(int i=1;i<pref.length;i++){
            pref[i]=pref[i-1]+stoneValue[i];
        }
        Integer dp[][]=new Integer[stoneValue.length][stoneValue.length];
        return solve(pref,0,pref.length-1,dp);
    }
}