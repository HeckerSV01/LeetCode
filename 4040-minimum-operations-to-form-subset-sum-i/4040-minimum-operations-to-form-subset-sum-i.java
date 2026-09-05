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
        int mult=Integer.MAX_VALUE;
        int val=a[i];
        while(currsum+val<=sum){
            int temp=solve(a,i+1,currsum+val,sum,dp);
            if(temp!=Integer.MAX_VALUE){
                mult=Math.min(mult,temp+count);
            }
            val=val*2;
            count++;
        }
        val=a[i];
        count=0;
        int div=Integer.MAX_VALUE;
        while(val>0){
            if(currsum+val<=sum){
                int temp=solve(a,i+1,currsum+val,sum,dp);
                if(temp!=Integer.MAX_VALUE){
                    div=Math.min(div,temp+count);
                }
            }
            val=val/2;
            count++;
        }
        return dp[i][currsum]=Math.min(res,Math.min(mult,div));
    }

    public int minOperations(int[] nums, int sum) {
        Integer dp[][]=new Integer[101][5001];
        int n=solve(nums,0,0,sum,dp);
        return (n==Integer.MAX_VALUE)?-1:n;
    }
}