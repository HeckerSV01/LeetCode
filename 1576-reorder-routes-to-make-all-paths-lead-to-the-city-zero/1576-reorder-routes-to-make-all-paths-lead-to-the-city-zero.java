class Solution {
    int res=0;
    public void dfs(int node,int vis[],List<List<int[]>> adj)
    {
        vis[node]=1;
        for(int k[]:adj.get(node))
        {
            int n=k[0];
            int dir=k[1];
            if(vis[n]==0)
            {
                res=res+dir;
                dfs(n,vis,adj);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++)
        {
            adj.get(connections[i][0]).add(new int[]{connections[i][1],1});
            adj.get(connections[i][1]).add(new int[]{connections[i][0],0});
        }
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adj);
            }
        }
        return res;
    }
}