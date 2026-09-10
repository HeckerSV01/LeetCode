class Solution {
    private int solve(int arr[][], int i, int a, int b,Integer dp[][][]){
        if(i==arr.length){
            return 0;
        }
        if(dp[i][a][b]!=null){
            return dp[i][a][b];
        }
        int take1=Integer.MAX_VALUE;
        int take2=Integer.MAX_VALUE;
        if(a>0){
            take1=Math.min(take1, arr[i][0]+solve(arr,i+1,a-1,b,dp));
        }
        if(b>0){
            take2=Math.min(take2, arr[i][1]+solve(arr,i+1,a,b-1,dp));
        }
        return dp[i][a][b]=Math.min(take1,take2);
    }
    public int twoCitySchedCost(int[][] costs) {
        Integer dp[][][]=new Integer[costs.length][51][51];
        return solve(costs,0,costs.length/2,costs.length/2,dp);
    }
}