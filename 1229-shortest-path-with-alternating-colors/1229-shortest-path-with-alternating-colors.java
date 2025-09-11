class variabl{
    int node;
    int dis;
    int color;
    public variabl(int node,int dis,int color)
    {
        this.node=node;
        this.dis=dis;
        this.color=color;
    }
}
class pair{
    int node;
    int color;
    public pair(int node,int color)
    {
        this.node=node;
        this.color=color;
        //0 for red
        //1 for blue
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red, int[][] blue) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<red.length;i++)
        {
            adj.get(red[i][0]).add(new pair(red[i][1],0));
        }
        for(int i=0;i<blue.length;i++)
        {
            adj.get(blue[i][0]).add(new pair(blue[i][1],1));
        }
        Queue<variabl> q=new LinkedList<>();
        boolean vis[][]=new boolean[n][2];
        int res[]=new int[n];
        Arrays.fill(res,-1);
        q.add(new variabl(0,0,-1));
        res[0]=0;
        while(!q.isEmpty())
        {
            variabl p=q.remove();
            int node=p.node;
            int dis=p.dis;
            int nodecolor=p.color;
            for(pair k:adj.get(node))
            {
                int adjnode=k.node;
                int adjcolor=k.color;
                if(nodecolor!=adjcolor&&vis[adjnode][adjcolor]==false)
                {
                    vis[adjnode][adjcolor]=true;
                    if(res[adjnode]==-1)
                    {
                        res[adjnode]=dis+1;
                    }
                    q.add(new variabl(adjnode,dis+1,adjcolor));
                }
                else
                {
                    continue;
                }
            }
        }
        return res;
    }
}