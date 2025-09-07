class Solution {
    int nodes;
    int edges;
    public void dfs(List<List<Integer>> adj,int vis[],int node)
    {
        vis[node]=1;
        nodes++;
        for(int k:adj.get(node))
        {
            edges++;
            if(vis[k]==0)
            {
                dfs(adj,vis,k);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edge) {
        List<List<Integer>> adj=new ArrayList<>();
        int count=0;
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++)
        {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                nodes=0;
                edges=0;
                dfs(adj,vis,i);
                if(nodes*(nodes-1)/2==edges/2)
                {
                    count++;
                }
            }
        }
        return count;
    }
}