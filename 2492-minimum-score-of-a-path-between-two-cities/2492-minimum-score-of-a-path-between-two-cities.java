class pair{
    int node;
    int wt;
    public pair(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
        }
        int min=Integer.MAX_VALUE;
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[n+1];
        q.add(1);
        vis[1]=1;
        while(!q.isEmpty())
        {
            int p=q.remove();
            for(pair k:adj.get(p))
            {
                min=Math.min(min,k.wt);
                if(vis[k.node]==0)
                {
                    vis[k.node]=1;
                    q.add(k.node);
                }
            }
        }
        return min;
    }
}