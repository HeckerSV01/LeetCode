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
    public int[] baseUnitConversions(int[][] conversions) {
        List<List<pair>> adj=new ArrayList<>();
        int n=conversions.length+1;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<conversions.length;i++)
        {
            adj.get(conversions[i][0]).add(new pair(conversions[i][1],conversions[i][2]));
        }
        Queue<pair> q=new LinkedList<>();
        int res[]=new int[n];
        q.add(new pair(0,1));
        while(!q.isEmpty())
        {
            pair p=q.remove();
            int node=p.node;
            int fact=p.wt;
            res[node]=fact;
            for(pair k:adj.get(node))
            {
                int adjnode=k.node;
                int adjfact=k.wt;
                if(res[adjnode]!=0)
                {
                    continue;
                }
                q.add(new pair(adjnode,(int)(((1L*adjfact%1000000007)*(fact%1000000007))%1000000007)));
            }
        } 
        return res;
    }
}