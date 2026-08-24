class Solution {
    private int solve(int a[],int i,Integer dp[]){
        if(i==a.length-1){
            return a[i];
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int take=a[i]-solve(a,i+1,dp);
        int skip=solve(a,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }

    public int stoneGameVIII(int[] stones) {
        int pref[]=new int[stones.length];
        pref[0]=stones[0];
        for(int i=1;i<stones.length;i++){
            pref[i]=pref[i-1]+stones[i];
        }
        Integer dp[]=new Integer[stones.length];
        return solve(pref,1,dp);
    }
}