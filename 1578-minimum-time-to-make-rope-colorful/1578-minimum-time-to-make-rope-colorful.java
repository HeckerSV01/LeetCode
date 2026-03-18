class Solution {
    private int solve(String s,int a[],int i,char prevcol,int prevtime,int dp[]){
        if(i==a.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        if(s.charAt(i)==prevcol){
            return dp[i]=Math.min(prevtime,a[i])+solve(s,a,i+1,prevcol,Math.max(prevtime,a[i]),dp);
        }else{
            return dp[i]=solve(s,a,i+1,s.charAt(i),a[i],dp);
        }
    }
    public int minCost(String colors, int[] neededTime) {
        int dp[]=new int[colors.length()];
        Arrays.fill(dp,-1);
        return solve(colors,neededTime,0,'A',-1,dp);
    }
}