class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            adj.get(i).add(i + 1);
        }
        int res[] = new int[queries.length];
        int l = 0;
        for (int k[] : queries) {
            adj.get(k[0]).add(k[1]);
            Queue<Integer> q = new LinkedList<>();
            int vis[] = new int[n];
            int steps = 0;
            q.add(0);
            vis[0] = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int cur = q.remove();
                    if (cur == n - 1) {
                        res[l] = steps;
                        l++;
                        break;
                    }
                    for (int nx : adj.get(cur)) {
                        if (vis[nx] == 0) {
                            vis[nx] = 1;
                            q.add(nx);
                        }
                    }
                }
                steps++;
            }
        }
        return res;
    }
}