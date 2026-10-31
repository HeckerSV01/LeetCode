class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    private int solve(int nums[],int mask,int step,int dp[]){
        if (step > nums.length / 2) {
            return 0;
        }
        if(dp[mask]!=-1){
            return dp[mask];
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(i!=j&&(mask&(1<<i))==0&&(mask&(1<<j))==0){    
                    int newmask=mask|(1<<i)|(1<<j);                
                    int temp=step*gcd(nums[i],nums[j]);
                    temp+=solve(nums,newmask,step+1,dp);
                    max=Math.max(max,temp);
                }
            }
        }
        return dp[mask]=max;
    }
    public int maxScore(int[] nums) {
        boolean isTaken[]=new boolean[nums.length];
        int dp[]=new int[1<<14];
        Arrays.fill(dp,-1);
        return solve(nums,0,1,dp);
    }
}