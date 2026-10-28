class Solution {
    int res=Integer.MIN_VALUE;
    private void dfs(List<List<int[]>> adj,int val[],int remtime,boolean vis[],int n,int quality){
        if(n==0){
            res=Math.max(res,quality);
        }
        for(int a[]:adj.get(n)){
            int adjnode=a[0];
            int time=a[1];
            if(time>remtime){
                continue;
            }
            boolean firstvis=!vis[adjnode];
            if(firstvis){
                vis[adjnode]=true;
                quality+=val[adjnode];
            }
            dfs(adj,val,remtime-time,vis,adjnode,quality);
            if(firstvis){
                vis[adjnode]=false;
                quality-=val[adjnode];
            }
        }
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<values.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
            adj.get(e[1]).add(new int[]{e[0],e[2]});
        }
        boolean vis[]=new boolean[values.length];
        vis[0]=true;
        dfs(adj,values,maxTime,vis,0,values[0]);
        return res;
    }
}