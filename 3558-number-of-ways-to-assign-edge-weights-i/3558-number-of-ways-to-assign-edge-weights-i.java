class Solution {
    public int assignEdgeWeights(int[][] edges) {
        final int mod=1000000007;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=edges.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int k[]:edges){
            adj.get(k[0]).add(k[1]);
            adj.get(k[1]).add(k[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[edges.length+2];
        q.add(1);
        vis[1]=true;
        int height=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int node=q.poll();
                for(int n:adj.get(node)){
                    if(!vis[n]){
                        vis[n]=true;
                        q.add(n);
                    }
                }
            }
            height++;
        }
        height=height-2;
        return power(2,height,mod);
    }
    private int power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return (int) res;
    }
}