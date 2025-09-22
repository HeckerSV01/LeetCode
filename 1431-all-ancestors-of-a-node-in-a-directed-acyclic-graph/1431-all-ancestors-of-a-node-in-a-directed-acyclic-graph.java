class Solution {
    public void dfs(int node,int root,List<List<Integer>> adj,int vis[],List<List<Integer>> res)
    {
        vis[node]=1;
        for(int k:adj.get(node))
        {
            if(vis[k]==0)
            {
                res.get(root).add(k);
                dfs(k,root,adj,vis,res);
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++)
        {
            int vis[]=new int[n];
            dfs(i,i,adj,vis,res);
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> l=new ArrayList<>(res.get(i));
            Collections.sort(l);
            list.add(l);
        }
        return list;
    }
}