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
    public void bfs(int edges[],int node,int dist[])
    {
        int vis[]=new int[edges.length];
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(node,0));
        vis[node]=1;
        while(!q.isEmpty())
        {
            pair p=q.remove();
            int curr=p.node;
            int dis=p.dis;
            dist[curr]=dis;
            int next=edges[curr];
            if(next!=-1&&vis[next]==0)
            {
                vis[next]=1;
                q.add(new pair(next,dis+1));
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int dis1[]=new int[n];
        int dis2[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dis1[i]=-1;
            dis2[i]=-1;
        }
        bfs(edges,node1,dis1);
        bfs(edges,node2,dis2);
        int min=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(dis1[i]!=-1&&dis2[i]!=-1)
            {
                int max=Math.max(dis1[i],dis2[i]);
                if(max<min)
                {
                    min=max;
                    idx=i;
                }
            }
        }
        return idx;
    }
}