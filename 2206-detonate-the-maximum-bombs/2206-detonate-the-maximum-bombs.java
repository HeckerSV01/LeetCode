class Solution {
    int max=-1;
    int count;
    public void dfs(int node,int vis[],List<List<Integer>> adj)
    {
        if(vis[node]!=0)
        {
            return;
        }
        vis[node]=1;
        count++;
        for(int k:adj.get(node))
        {
            if(vis[k]==0)
            {
                dfs(k,vis,adj);
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=bombs.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    continue;
                }
                long dx=bombs[i][0]-bombs[j][0];
                long dy=bombs[i][1]-bombs[j][1];
                long r=bombs[i][2];
                if(dx*dx+dy*dy<=r*r) 
                {
                    adj.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            count=0;
            int vis[]=new int[n];
            dfs(i,vis,adj);
            max=Math.max(max,count);
        }
        return max;
    }
}