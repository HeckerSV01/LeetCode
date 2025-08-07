class Solution {
    public List<List<Integer>> mattolist(int a[][])
    {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=a.length;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length;j++)
            {
                if(a[i][j]==1)
                {
                    list.get(i+1).add(j+1);
                }
            }
        }
        return list;
    }
    public void dfs(int i,List<List<Integer>> list,int vis[])
    {
        vis[i]=1;
        for(int k:list.get(i))
        {
            if(vis[k]!=1)
            {
                dfs(k,list,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list=mattolist(isConnected);
        int count=0;
        int vis[]=new int[list.size()];
        for(int i=1;i<list.size();i++)
        {
            if(vis[i]!=1)
            {
                count++;
                dfs(i,list,vis);
            }
        }
        return count;
    }
}