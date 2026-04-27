class Solution {
    final int dir[][] = { { 0, -1, 0, 1 }, { -1, 0, 1, 0 }, { 0, -1, 1, 0 }, { 1, 0, 0, 1 }, { 0, -1, -1, 0 },
            { -1, 0, 0, 1 } };

    private boolean dfs(int grid[][], boolean vis[][], int i, int j, int m, int n) {
        vis[i][j] = true;
        if (i == m && j == n) {
            return true;
        }
        int x = grid[i][j] - 1;
        int dirn[] = dir[x];
        int ni1 = i + dirn[0];
        int nj1 = j + dirn[1];
        int ni2 = i + dirn[2];
        int nj2 = j + dirn[3];
        if (isvalid(ni1, nj1, m, n) && !vis[ni1][nj1]) {
            int prevdir[] = dir[grid[ni1][nj1] - 1];
            int i1 = prevdir[0];
            int j1 = prevdir[1];
            int i2 = prevdir[2];
            int j2 = prevdir[3];
            boolean check = false;
            if (ni1 + i1 == i && nj1 + j1 == j) {
                check = true;
            }
            if (ni1 + i2 == i && nj1 + j2 == j) {
                check = true;
            }
            if (check) {
                if (dfs(grid, vis, ni1, nj1, m, n)) {
                    return true;
                }
            }
        }
        if (isvalid(ni2, nj2, m, n) && !vis[ni2][nj2]) {
            int prevdir[] = dir[grid[ni2][nj2] - 1];
            int i1 = prevdir[0];
            int j1 = prevdir[1];
            int i2 = prevdir[2];
            int j2 = prevdir[3];
            boolean check = false;
            if (ni2 + i1 == i && nj2 + j1 == j) {
                check = true;
            }
            if (ni2 + i2 == i && nj2 + j2 == j) {
                check = true;
            }
            if (check) {
                if (dfs(grid, vis, ni2, nj2, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isvalid(int i, int j, int m, int n) {
        return (i >= 0 && i <= m && j >= 0 && j <= n);
    }

    public boolean hasValidPath(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        return dfs(grid, vis, 0, 0, grid.length - 1, grid[0].length - 1);
    }
}