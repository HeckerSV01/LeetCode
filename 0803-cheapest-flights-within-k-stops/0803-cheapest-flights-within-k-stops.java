class pair{
    int first;
    int second;
    public pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class info{
    int stops;
    int node;
    int cost;
    public info(int stops,int node,int cost)
    {
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        int costs[]=new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        for(int i=0;i<n;i++)
        {
            costs[i]=Integer.MAX_VALUE;
        }
        Queue<info> q=new LinkedList<>();
        q.add(new info(0,src,0));
        costs[src]=0;
        while(!q.isEmpty())
        {
            info curr=q.remove();
            int stops=curr.stops;
            int node=curr.node;
            int cost=curr.cost;
            if(stops>k)
            {
                continue;
            }
            for(pair i:adj.get(node))
            {
                int adjnode=i.first;
                int price=i.second;
                if(cost+price<costs[adjnode]&&stops<=k)
                {
                    costs[adjnode]=cost+price;
                    q.add(new info(stops+1,adjnode,cost+price));
                }
            }
        }
        if(costs[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return costs[dst];
    }
}