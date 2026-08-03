class Solution {
    private int solve(int a[],int i,Integer dp[]){
        if(i==a.length){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int score=Integer.MIN_VALUE;
        int rem=a.length-i;
        score=Math.max(score,a[i]-solve(a,i+1,dp));
        if(rem>=2){
            score=Math.max(score,a[i]+a[i+1]-solve(a,i+2,dp));
        }
        if(rem>=3){
            score=Math.max(score,a[i]+a[i+1]+a[i+2]-solve(a,i+3,dp));
        }
        return dp[i]=score;
    }
    public String stoneGameIII(int[] stoneValue) {
        Integer dp[]=new Integer[stoneValue.length];
        int res=solve(stoneValue,0,dp);
        if(res>0){
            return new String("Alice");
        }else if(res==0){
            return new String("Tie");
        }else{
            return new String("Bob");
        }
    }
}