class Solution {
    int sum = 0;

    private void dfs(int a[][], int vis[][], int i, int j, int m, int n) {
        vis[i][j] = 1;
        sum = sum + a[i][j];
        int dir[][] = { { 0, 0, 1, -1 }, { -1, 1, 0, 0 } };
        for (int k = 0; k < 4; k++) {
            int r = i + dir[0][k];
            int c = j + dir[1][k];
            if (r >= 0 && r < m && c >= 0 && c < n && a[r][c] != 0 && vis[r][c] == 0) {
                dfs(a, vis, r, c, m, n);
            }
        }
    }

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && vis[i][j] == 0) {
                    sum = 0;
                    dfs(grid, vis, i, j, m, n);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}