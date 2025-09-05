class Solution {
    public void dfs(List<List<Integer>> adj,int vis[],Stack<Integer> st,int node)
    {
        vis[node]=1;
        for(int k:adj.get(node))
        {
            if(vis[k]==0)
            {
                dfs(adj,vis,st,k);
            }
        }
        st.push(node);
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        Stack<Integer> st=new Stack<>();
        int vis[]=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<richer.length;i++)
        {
            adj.get(richer[i][0]).add(richer[i][1]);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(adj,vis,st,i);
            }
        }
        int topo[]=new int[n];
        int k=0;
        while(!st.isEmpty())
        {
            topo[k]=st.pop();
            k++;
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=i; 
        }
        for(int u:topo) 
        {
            for (int v:adj.get(u)) 
            { 
                if(quiet[res[u]]<quiet[res[v]]) 
                {
                    res[v]=res[u];
                }
            }
        }
        return res;
    }
}