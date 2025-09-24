class pair{
    int node;
    int wt;
    public pair(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}
class Graph {
List<List<pair>> adj;
int n;
    public Graph(int n, int[][] edges) {
        adj=new ArrayList<>();
        this.n=n;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new pair(edge[1],edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[node1]=0;
        pq.add(new pair(node1,0));
        while(!pq.isEmpty())
        {
            pair p=pq.remove();
            int node=p.node;
            int dis=p.wt;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int wt=adj.get(node).get(i).wt;
                int adjnode=adj.get(node).get(i).node;
                if(dis+wt<dist[adjnode])
                {
                    dist[adjnode]=dis+wt;
                    pq.add(new pair(adjnode,dist[adjnode]));
                }
            }
        }
        if(dist[node2]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */