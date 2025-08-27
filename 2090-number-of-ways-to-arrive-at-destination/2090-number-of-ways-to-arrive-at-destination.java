class info{
    int node;
    long dis;
    public info(long dis,int node)
    {
        this.dis=dis;
        this.node=node;
    }
}
class pair{
    int first;
    int second;
    public pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
        }
        int mod=1000000007;
        long ways[]=new long[n];
        long dis[]=new long[n];
        for(int i=0;i<n;i++)
        {
            ways[i]=0;
            dis[i]=Long.MAX_VALUE;
        }
        ways[0]=1;
        dis[0]=0;
        PriorityQueue<info> pq=new PriorityQueue<>((x,y)->Long.compare(x.dis, y.dis));
        pq.add(new info(0,0));
        while(pq.size()!=0)
        {
            info curr=pq.remove();
            int node=curr.node;
            long dist=curr.dis;
            for(pair p:adj.get(node))
            {
                int adjnode=p.first;
                int weight=p.second;
                if(dist+weight<dis[adjnode])
                {
                    dis[adjnode]=dist+weight;
                    pq.add(new info(dist+weight,adjnode));
                    ways[adjnode]=ways[node];
                }
                else if(dist+weight==dis[adjnode])
                {
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1]%mod;
    }
}