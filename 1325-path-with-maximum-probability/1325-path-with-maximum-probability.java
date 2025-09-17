class pair{
    int node;
    double wt;
    public pair(double wt,int node)
    {
        this.wt=wt;
        this.node=node;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double prob[]=new double[n];
        for(int i=0;i<n;i++)
        {
            prob[i]=0.0;
        }
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new pair(succProb[i],edges[i][1]));
            adj.get(edges[i][1]).add(new pair(succProb[i],edges[i][0]));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->Double.compare(y.wt,x.wt));
        prob[start]=1;
        pq.add(new pair(1,start));
        while(pq.size()!=0)
        {
            pair p=pq.remove();
            int node=p.node;
            double wt=p.wt;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int adjnode=adj.get(node).get(i).node;
                double adjwt=adj.get(node).get(i).wt;
                if(wt*adjwt>prob[adjnode])
                {
                    prob[adjnode]=wt*adjwt;
                    pq.add(new pair(prob[adjnode],adjnode));
                }
            }
        }
        return prob[end];
    }
}