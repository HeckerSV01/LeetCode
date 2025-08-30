class Solution {
    public int findTheCity(int n, int[][] edges, int disthres) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++)
        {
            int src=edges[i][0];
            int des=edges[i][1];
            int wt=edges[i][2];
            dist[src][des]=wt;
            dist[des][src]=wt;
        }
        for(int i=0;i<n;i++)
        {
            dist[i][i]=0;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE)
                    {
                        continue;
                    }
                    else
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int res=n;
        int cityno=-1;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=disthres)
                {
                    count++;
                }
            }
            if(count<=res)
            {
                res=count;
                cityno=i;
            }
        }
        return cityno;
    }
}