class Solution {
    public boolean check(int [][]graph,int col[],int start)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        col[start]=1;
        while(!q.isEmpty())
        {
            int curr=q.remove();
            for(int a:graph[curr])
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
                }
                else if(col[a]==col[curr])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(col[i]==0)
            {
                if(!check(graph,col,i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}