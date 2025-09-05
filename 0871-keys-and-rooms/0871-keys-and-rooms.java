class Solution {
    public void dfs(List<List<Integer>> rooms,int vis[],int node)
    {
        vis[node]=1;
        for(int k:rooms.get(node))
        {
            if(vis[k]==0)
            dfs(rooms,vis,k);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int vis[]=new int[rooms.size()];
        vis[0]=1;
        for(int k:rooms.get(0))
        {
            dfs(rooms,vis,k);
        }
        for(int k:vis)
        {
            if(k==0)
            {
                return false;
            }
        }
        return true;
    }
}