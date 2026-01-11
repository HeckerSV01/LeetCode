class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];
        q.add(start);
        vis[start] = 1;
        while (!q.isEmpty()) {
            int k = q.remove();
            if (arr[k] == 0) {
                return true;
            }
            int idx1 = k + arr[k];
            int idx2 = k - arr[k];
            if (idx1 >= 0 && idx1 < n && vis[idx1] == 0) {
                q.add(idx1);
                vis[idx1] = 1;
            }
            if (idx2 >= 0 && idx2 < n && vis[idx2] == 0) {
                q.add(idx2);
                vis[idx2] = 1;
            }
        }
        return false;
    }
}