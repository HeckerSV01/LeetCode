class Solution {
    private void bfs(List<List<Integer>> adj, int a[], int node, int level) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int vis[]=new int[adj.size()];
        vis[node] = 1;
        int k = 0;
        int count = 0;
        while (!q.isEmpty() && k <= level) {
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                count++;
                for (int j : adj.get(curr)) {
                    if (vis[j] == 0) {
                        vis[j] = 1;
                        q.add(j);
                    }
                }
            }
            k++;
        }
        a[node] = count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m = edges2.length+1;
        int n = edges1.length+1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj2.add(new ArrayList<>());
        }
        for (int i = 0; i < edges1.length; i++) {
            adj1.get(edges1[i][0]).add(edges1[i][1]);
            adj1.get(edges1[i][1]).add(edges1[i][0]);
        }
        for (int i = 0; i < edges2.length; i++) {
            adj2.get(edges2[i][0]).add(edges2[i][1]);
            adj2.get(edges2[i][1]).add(edges2[i][0]);
        }
        int nodes1[] = new int[n];
        int nodes2[] = new int[m];
        for (int i = 0; i < n; i++) {
            bfs(adj1, nodes1, i, k);
        }
        for (int i = 0; i < m; i++) {
            bfs(adj2, nodes2, i, k - 1);
        }
        int max2=-1;
        for(int i=0;i<m;i++){
            max2=Math.max(max2, nodes2[i]);
        }
        for(int i=0;i<n;i++){
            nodes1[i]=nodes1[i]+max2;
        }
        return nodes1;
    }
}