class Solution {
    int res=1;
    public void dfs(int node,List<List<Integer>> adj,int vis[])
    {
        vis[node]=1;
        for(int k:adj.get(node))
        {
            if(vis[k]==0)
            {
                res++;
                dfs(k,adj,vis);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int vis[]=new int[n];
        for(int i=0;i<restricted.length;i++)
        {
            vis[restricted[i]]=1;
        }
        dfs(0,adj,vis);
        return res;
    }
}