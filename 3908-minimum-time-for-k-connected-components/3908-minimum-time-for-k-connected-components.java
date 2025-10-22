class Solution {
    int c=0;
    public int components(int edges[][],int time,int n)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][2]>time)
            {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
        }
        int vis[]=new int[n];
        c=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(adj,i,vis);
                c++;
            }
        }
        return c;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int i,int vis[])
    {
        vis[i]=1;
        for(int k:adj.get(i))
        {
            if(vis[k]==0)
            {
                dfs(adj,k,vis);
            }
        }
    }
    public int minTime(int n, int[][] edges, int k) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        for(int i=0;i<edges.length;i++)
        {
            list.add(edges[i][2]);
        }
        Collections.sort(list);
        int st=0;
        int en=list.size()-1;
        int res=Integer.MAX_VALUE;
        while(st<=en)
        {
            int mid=(st+en)/2;
            if(components(edges,list.get(mid),n)>=k)
            {
                en=mid-1;
                res=list.get(mid);
            }
            else if(components(edges,list.get(mid),n)<k)
            {
                st=mid+1;
            }
        }
        return res;
    }
}