class info {
    int i;
    int j;

    public info(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    Queue<info> q = new LinkedList<>();
    int dir[][] = { { 0, 0, -1, 1 }, { -1, 1, 0, 0 } };

    private void dfs(int grid[][], int vis[][], int i, int j, int m, int n) {
        vis[i][j] = 1;
        q.add(new info(i, j));
        for (int k = 0; k < 4; k++) {
            int r = i + dir[0][k];
            int c = j + dir[1][k];
            if (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] == 0 && grid[r][c] == 1) {
                dfs(grid, vis, r, c, m, n);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m && !flag; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    dfs(grid, vis, i, j, m, n);
                    flag = true;
                    break;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                info cur = q.remove();
                int r = cur.i;
                int c = cur.j;
                for (int j = 0; j < 4; j++) {
                    int nr = r + dir[0][j];
                    int nc = c + dir[1][j];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0) {
                        if (grid[nr][nc] == 1) {
                            return count;
                        }
                        vis[nr][nc] = 1;
                        q.add(new info(nr, nc));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}