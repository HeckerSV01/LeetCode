class Solution {

    private void dfs(List<List<Integer>> adj, int a[], int count[], int node, boolean color) {
        if (color) {
            int col = 1;
            a[node] = col;
            count[col]++;
        } else {
            int col = 0;
            a[node] = col;
            count[col]++;
        }
        for (int k : adj.get(node)) {
            if (a[k] == -1) {
                dfs(adj, a, count, k, !color);
            }
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m = edges2.length + 1;
        int n = edges1.length + 1;
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
        int color1[] = new int[n];
        int color2[] = new int[m];
        Arrays.fill(color1, -1);
        Arrays.fill(color2, -1);
        int count1[] = new int[2];
        int count2[] = new int[2];
        dfs(adj1, color1, count1, 0, true);
        dfs(adj2, color2, count2, 0, true);
        int nodes1[] = new int[n];
        int nodes2[] = new int[m];
        for (int i = 0; i < n; i++) {
            nodes1[i] = count1[color1[i]];
        }
        for (int i = 0; i < m; i++) {
            nodes2[i] = count2[color2[i]];
        }
        int max2 = -1;
        for (int i = 0; i < m; i++) {
            max2 = Math.max(max2, nodes2[i]);
        }
        for (int i = 0; i < n; i++) {
            nodes1[i] = nodes1[i] + max2;
        }
        return nodes1;
    }
}