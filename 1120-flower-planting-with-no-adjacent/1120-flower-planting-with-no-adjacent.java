class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<paths.length;i++)
        {
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }
        int vis[]=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        for(int i=1;i<=n;i++)
        {
            if(vis[i]==0)
            {
                q.add(i);
            }
            while(!q.isEmpty())
            {
                int cur=q.remove();
                boolean check[]=new boolean[5];
                for(int k:adj.get(cur))
                {
                    if(vis[k]!=0)
                    {
                        check[vis[k]]=true;
                    }
                }
                for(int k=1;k<5;k++)
                {
                    if(!check[k])
                    {
                        vis[cur]=k;
                        break;
                    }
                }
                for(int k:adj.get(cur))
                {
                    if(vis[k]==0)
                    {
                        q.add(k);
                    }
                }
            }
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=vis[i+1];
        }
        return res;
    }
}