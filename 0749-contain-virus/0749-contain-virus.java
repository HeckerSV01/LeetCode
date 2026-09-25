class Cell {
    int i;
    int j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Cell))
            return false;

        Cell c = (Cell) obj;
        return i == c.i && j == c.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

class Region {
    HashSet<Cell> infected;
    HashSet<Cell> danger;
    int wallsreq;

    public Region() {
        infected = new HashSet<>();
        danger = new HashSet<>();
    }

    public Region(HashSet<Cell> infected, HashSet<Cell> danger, int wallsreq) {
        this.infected = infected;
        this.danger = danger;
        this.wallsreq = wallsreq;
    }
}

class Solution {
    final int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void dfs(int infected[][], boolean vis[][], int i, int j, int m, int n, Region r) {
        if (i < 0 || i >= m || j < 0 || j >= n || infected[i][j] == 2) {
            return;
        }
        if (infected[i][j] == 0) {
            r.wallsreq++;
            r.danger.add(new Cell(i, j));
            return;
        }

        if (infected[i][j] == 1) {
            r.infected.add(new Cell(i, j));
        }
        if (vis[i][j]) {
            return;
        }
        vis[i][j] = true;

        for (int d[] : dir) {
            dfs(infected, vis, i + d[0], j + d[1], m, n, r);
        }
    }

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        int res = 0;
        while (true) {
            List<Region> regions = new ArrayList<>();
            boolean vis[][] = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !vis[i][j]) {
                        Region r = new Region();
                        dfs(isInfected, vis, i, j, m, n, r);
                        regions.add(r);
                    }
                }
            }
            if (regions.size() == 0) {
                break;
            }
            Collections.sort(regions, (a, b) -> b.danger.size() - a.danger.size());
            Region mostinfection = regions.remove(0);
            res += mostinfection.wallsreq;
            for (Cell c : mostinfection.infected) {
                isInfected[c.i][c.j] = 2;
            }
            for (Region r : regions) {
                for (Cell c : r.danger) {
                    isInfected[c.i][c.j] = 1;
                }
            }
        }
        return res;
    }
}