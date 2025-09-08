class Solution {
    int step=0;
    public void dfs(int node,int parent,List<List<Integer>> adj,int vis[],int time[],int min[],List<List<Integer>> res)
    {
        vis[node]=1;
        time[node]=step;
        min[node]=step;
        step++;
        for(int k:adj.get(node))
        {
            if(k==parent)
            {
                continue;
            }
            if(vis[k]==0)
            {
                dfs(k,node,adj,vis,time,min,res);
                min[node]=Math.min(min[node],min[k]);
                if(min[k]>time[node])
                {
                    res.add(Arrays.asList(k,node));
                }
            }
            else
            {
                min[node]=Math.min(min[k],min[node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> l:connections)
        {
            adj.get(l.get(0)).add(l.get(1));
            adj.get(l.get(1)).add(l.get(0));
        }
        List<List<Integer>> res=new ArrayList<>();
        int vis[]=new int[n];
        int time[]=new int[n];
        int min[]=new int[n];
        dfs(0,-1,adj,vis,time,min,res);
        return res;
    }
}