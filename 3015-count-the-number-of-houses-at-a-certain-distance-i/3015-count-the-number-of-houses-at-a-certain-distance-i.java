class Solution {
    private void bfs(List<List<Integer>> adj, int st, int n, int res[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(st);
        List<Integer> list=new ArrayList<>();
        int dis=0;
        int vis[]=new int[n+1];
        Arrays.fill(vis, -1);
        vis[st]=0;
        while(!q.isEmpty()){
            int cur=q.remove();
            for(int nxt:adj.get(cur)){
                if(vis[nxt]==-1){
                    vis[nxt]=vis[cur]+1;
                    q.add(nxt);
                    res[vis[nxt]-1]++;
                }
            }
        }
    }
    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            adj.get(i).add(i+1);
            adj.get(i+1).add(i);
        }
        adj.get(x).add(y);
        adj.get(y).add(x);
        int res[]=new int[n];
        for(int i=1;i<=n;i++){
            bfs(adj, i, n,res);
        }
        return res;
    }
}