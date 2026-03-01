class Solution {
    private int cal(int a[],int i,int time,Integer dp[][]){
        if(i==a.length){
            return 0;
        }
        if(dp[i][time]!=null){
            return dp[i][time];
        }
        int nottake=cal(a,i+1,time,dp);
        int take=time*a[i]+cal(a,i+1,time+1,dp);
        return dp[i][time]=Math.max(nottake,take);
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        Integer dp[][]=new Integer[satisfaction.length][satisfaction.length+2];
        return cal(satisfaction,0,1,dp);
    }
}