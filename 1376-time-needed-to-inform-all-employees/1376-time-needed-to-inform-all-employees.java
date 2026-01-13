class Solution {
    private int dfs(int cur, List<List<Integer>> adj, int[] informTime) {
        int max = 0;
        for (int child : adj.get(cur)) {
            max = Math.max(max, dfs(child, adj, informTime));
        }
        return informTime[cur] + max;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) {
                continue;
            }
            adj.get(manager[i]).add(i);
        }
        return dfs(headID, adj, informTime);
    }
}