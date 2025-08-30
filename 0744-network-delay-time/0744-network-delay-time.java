class pair{
    int dis;
    int node;
    public pair(int dis,int node)
    {
        this.dis=dis;
        this.node=node;
    }
}
class v{
    int first;
    int second;
    public v(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<v>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            adj.get(times[i][0]-1).add(new v(times[i][1],times[i][2]));
        }
        int time[]=new int[n];
        for(int i=0;i<n;i++)
        {
            time[i]=Integer.MAX_VALUE;
        }
        time[k-1]=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.dis-y.dis);
        pq.add(new pair(0,k));
        while(pq.size()!=0)
        {
            pair p=pq.remove();
            int dis=p.dis;
            int node=p.node;
            for(int i=0;i<adj.get(node-1).size();i++)
            {
                int wt=adj.get(node-1).get(i).second;
                int adjnode=adj.get(node-1).get(i).first;
                if(dis+wt<time[adjnode-1])
                {
                    time[adjnode-1]=dis+wt;
                    pq.add(new pair(time[adjnode-1],adjnode));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,time[i]);
            if(time[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
        }
        return max;
    }
}