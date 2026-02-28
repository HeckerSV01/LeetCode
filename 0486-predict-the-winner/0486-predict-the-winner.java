class Solution {
    private int cal(int a[],int i,int j,int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=a[i]-cal(a,i+1,j,dp);
        int right=a[j]-cal(a,i,j-1,dp);
        return dp[i][j]=Math.max(left,right);
    }
    public boolean predictTheWinner(int[] nums) {
        int dp[][]=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j]=-1;
            }
        }
        return cal(nums,0,nums.length-1,dp)>=0;
    }
}
//f(i,j) gives the maximum score difference with player1 starting first....