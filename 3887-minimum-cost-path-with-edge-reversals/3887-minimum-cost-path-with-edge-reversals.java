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
    public int minCost(int n, int[][] edges) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]*2));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        pq.add(new pair(0,0));
        dis[0]=0;
        while(!pq.isEmpty())
        {
            pair p=pq.remove();
            int node=p.node;
            int dist=p.wt;
            for(pair k:adj.get(node))
            {
                int adjnode=k.node;
                int adjwt=k.wt;
                if(adjwt+dist<dis[adjnode])
                {
                    dis[adjnode]=adjwt+dist;
                    pq.add(new pair(adjnode,dis[adjnode]));
                }
            }
        }
        if(dis[n-1]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dis[n-1];
    }
}