class Solution {
    public boolean check(List<List<Integer>> adj,int col[],int start,List<Integer> list)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        col[start]=1;
        while(!q.isEmpty())
        {
            int curr=q.remove();
            for(int a:adj.get(curr))
            {
                if(col[a]==0)
                {
                    if(col[curr]==1)
                    {
                        col[a]=2;
                    }
                    else
                    {
                        col[a]=1;
                    }
                    q.add(a);
                    list.add(a);
                }
                else if(col[a]==col[curr])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int bfs(List<List<Integer>> adj,int n,int node)
    {
        Queue<Integer> q=new LinkedList<>();
        int level[]=new int[n+1];
        Arrays.fill(level,-1);
        level[node]=1;
        q.add(node);
        int max=-1;
        while(!q.isEmpty())
        {
            int curr=q.remove();
            for(int k:adj.get(curr))
            {
                if(level[k]==-1)
                {
                    level[k]=level[curr]+1;
                    max=Math.max(max,level[k]);
                    q.add(k);
                }
            }
        }
        return max;
    }
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int col[]=new int[n+1];
        int res=0;
        for(int i=1;i<=n;i++)
        {
            if(col[i]==0)
            {
                List<Integer> list=new ArrayList<>();
                if(!check(adj,col,i,list))
                {
                    return -1;
                }
                int comp=1;
                for(int k:list)
                {
                    comp=Math.max(comp,bfs(adj,n,k));
                }
                res=res+comp;
            }
        }
        
        return res;
    }
}