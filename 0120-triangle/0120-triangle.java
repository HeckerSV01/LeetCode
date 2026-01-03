class Solution {
    public int cal(int i,int j,List<List<Integer>> list,int dp[][])
    {
        if(j<0||j>i)
        {
            return 1000000000;
        }
        if(i==0&&j==0)
        {
            return list.get(0).get(0);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int m1=list.get(i).get(j)+cal(i-1,j,list,dp);
        int m2=list.get(i).get(j)+cal(i-1,j-1,list,dp);
        return dp[i][j]=Math.min(m1,m2);
    }
    public int minimumTotal(List<List<Integer>> tri) {
        int res=Integer.MAX_VALUE;
        int dp[][]=new int[tri.size()][tri.size()];
        for(int i=0;i<tri.size();i++)
        {
            for(int j=0;j<tri.size();j++)
            {
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<tri.get(tri.size()-1).size();i++)
        {
            res=Math.min(res,cal(tri.size()-1,i,tri,dp));
        }
        return res;
    }
}