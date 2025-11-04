class Solution {
    public int dfs(List<List<Integer>> adj,List<Boolean> hasapple,int node,int parent)
    {
        int res=0;
        for(int k:adj.get(node))
        {
            if(parent==k)
            {
                continue;
            }
            int child=dfs(adj,hasapple,k,node);
            if(child>0||hasapple.get(k))
            {
                res=res+child+2;
            }
        }
        return res;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(i,new ArrayList<>());
        }
        for(int k[]:edges)
        {
            adj.get(k[0]).add(k[1]);
            adj.get(k[1]).add(k[0]);
        }
        return dfs(adj,hasApple,0,-1);
    }
}