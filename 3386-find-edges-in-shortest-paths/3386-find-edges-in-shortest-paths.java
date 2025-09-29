class pair{
    int node;
    int dis;
    public pair(int node,int dis)
    {
        this.node=node;
        this.dis=dis;
    }
}
class Solution {
    public long[] dijkstra(List<List<pair>> adj,int st,int n)
    {
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.dis-y.dis);
        long mindis[]=new long[n];
        Arrays.fill(mindis,Integer.MAX_VALUE);
        pq.add(new pair(st,0));
        mindis[st]=0;
        while(!pq.isEmpty())
        {
            pair p=pq.remove();
            int node=p.node;
            int dis=p.dis;
            if(dis>mindis[node])
            {
                continue;
            }
            for(pair k:adj.get(node))
            {
                int adjnode=k.node;
                int adjwt=k.dis;
                if(dis+adjwt<mindis[adjnode])
                {
                    mindis[adjnode]=dis+adjwt;
                    pq.add(new pair(adjnode,(int)mindis[adjnode]));
                }
            }
        }
        return mindis;
    }
    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
        }
        long disfrom0[]=dijkstra(adj,0,n);
        long disfromdes[]=dijkstra(adj,n-1,n);
        boolean res[]=new boolean[edges.length];
        if(disfrom0[n-1]==Integer.MAX_VALUE)
        {
            return res;
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            if(disfrom0[a]+edges[i][2]+disfromdes[b]==disfrom0[n-1])
            {
                res[i]=true;
            }
            if(disfrom0[b]+edges[i][2]+disfromdes[a]==disfrom0[n-1])
            {
                res[i]=true;
            }
        }
        return res;
    }
}