class Solution {
    private int solve(int[] a,int i, int currsum,int sum,Integer dp[][]){
        if(currsum==sum){
            return 0; 
        }
        if(i>=a.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][currsum]!=null){
            return dp[i][currsum];
        }
        int count=0;
        int res=Integer.MAX_VALUE;
        int skip=solve(a,i+1,currsum,sum,dp);
        res=Math.min(res,skip);
        int val=a[i];
        int divcount=0;
        int div=Integer.MAX_VALUE;
        while(val>0){
            int val2=val;
            int multcount=0;
            while(currsum+val2<=sum){
                int temp=solve(a,i+1,currsum+val2,sum,dp);
                if(temp!=Integer.MAX_VALUE){
                    res=Math.min(res,temp+divcount+multcount);
                }
                val2=val2*2;
                multcount++;
            }
            val=val/2;
            divcount++;
        }
        return dp[i][currsum]=res;
    }
    public int minOperations(int[] nums, int sum) {
        Integer dp[][]=new Integer[101][5001];
        int n=solve(nums,0,0,sum,dp);
        return (n==Integer.MAX_VALUE)?-1:n;
    }
}