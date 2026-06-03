class Solution {
    private int solve(int a1[],int a2[],int i,int j,Integer dp[][]){
        if(i==a1.length||j==a2.length){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int len=0;
        int res=Integer.MIN_VALUE;
        if(a1[i]!=a2[j]){
            return 0;
        }
        len=1+solve(a1,a2,i+1,j+1,dp);
        return dp[i][j]=len;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int res=-1;
        Integer dp[][]=new Integer[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                res=Math.max(res,solve(nums1,nums2,i,j,dp));
            }
        }
        return res;
    }
}