class Solution {
    final int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private boolean dfs(char grid[][], boolean vis[][], int i, int j, char prev, int previ, int prevj) {
        if (!vis[i][j] && grid[i][j] == prev) {
            vis[i][j] = true;
        }
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length) {
                if (grid[i][j] != grid[ni][nj]) {
                    continue;
                }
                if (ni == previ && nj == prevj) {
                    continue;
                }
                if (vis[ni][nj]) {
                    return true;
                }
                if (!vis[ni][nj] && grid[ni][nj] == grid[i][j]) {
                    if(dfs(grid, vis, ni, nj, grid[i][j], i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j]) {
                    if(dfs(grid, vis, i, j, grid[i][j], -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}