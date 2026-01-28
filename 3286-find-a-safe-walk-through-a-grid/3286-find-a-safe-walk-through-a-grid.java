class info {
    int i;
    int j;
    int hlt;

    public info(int i, int j, int hlt) {
        this.i = i;
        this.j = j;
        this.hlt = hlt;
    }
}

class Solution {
    final int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<info> pq = new PriorityQueue<>((a, b) -> b.hlt - a.hlt);
        int m = grid.size();
        int n = grid.get(0).size();
        int healths[][] = new int[m][n];
        pq.add(new info(0, 0, health - grid.get(0).get(0)));
        healths[0][0] = health - grid.get(0).get(0);
        while (!pq.isEmpty()) {
            info cur = pq.poll();
            int r = cur.i;
            int c = cur.j;
            int curhlt = cur.hlt;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int k = grid.get(nr).get(nc);
                    if (curhlt - k > healths[nr][nc]) {
                        healths[nr][nc] = curhlt - k;
                        pq.add(new info(nr, nc, healths[nr][nc]));
                    }
                }
            }
        }
        return healths[m - 1][n - 1] > 0;
    }
}