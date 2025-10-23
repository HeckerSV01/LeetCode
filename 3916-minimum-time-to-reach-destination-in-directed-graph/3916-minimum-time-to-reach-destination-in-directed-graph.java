class info1{
    int node;
    int time;
    public info1(int node,int time)
    {
        this.node=node;
        this.time=time;
    }
}
class info2{
    int node;
    int st;
    int en;
    public info2(int node,int st,int en)
    {
        this.node=node;
        this.st=st;
        this.en=en;
    }
}
class Solution {
    public int minTime(int n, int[][] edges) {
        PriorityQueue<info1> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        int times[]=new int[n];
        Arrays.fill(times,Integer.MAX_VALUE);
        ArrayList<ArrayList<info2>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int k[]:edges)
        {
            adj.get(k[0]).add(new info2(k[1],k[2],k[3]));
        }
        pq.add(new info1(0,0));
        times[0]=0;
        while(!pq.isEmpty())
        {
            info1 cur=pq.remove();
            int node=cur.node;
            int t=cur.time;
            if(t>times[node])
            { 
                continue;
            }
            for(info2 k:adj.get(node))
            {
                int nextnode=k.node;
                int stime=k.st;
                int etime=k.en;
                int t2=-1;
                if(t>etime)
                {
                    continue;
                }
                else if(t<stime)
                {
                    t2=stime+1;
                }
                else
                {
                    t2=t+1;
                }
                if(t2<=etime+1&&t2<times[nextnode])
                {
                    times[nextnode]=t2;
                    pq.add(new info1(nextnode,t2));
                }
            }
        }
        if(times[n-1]==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return times[n-1];
        }
    }
}