class Solution {
    public void bfs(List<List<Integer>> adj,int i,int reach[][])
    {
        int vis[]=new int[reach.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        vis[i]=1;
        while(!q.isEmpty())
        {
            int k=q.remove();
            for(int c:adj.get(k))
            {
                if(vis[c]==0)
                {
                    vis[c]=1;
                    q.add(c);
                }
            }
        }
        for(int j=0;j<reach.length;j++)
        {
            reach[i][j]=vis[j];
        }
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++)
        {
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        int reach[][]=new int[numCourses][numCourses];
        for(int i=0;i<numCourses;i++)
        {
            bfs(adj,i,reach);
        }
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            if(reach[queries[i][1]][queries[i][0]]==1)
            {
                res.add(true);
            }
            else
            {
                res.add(false);
            }
        }
        return res;
    }
}