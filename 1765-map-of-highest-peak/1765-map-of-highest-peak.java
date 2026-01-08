class info {
    int i;
    int j;
    int ht;
    public info(int i, int j, int ht) {
        this.i = i;
        this.j = j;
        this.ht = ht;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int res[][] = new int[m][n];
        int vis[][] = new int[m][n];
        Queue<info> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new info(i, j, 0));
                    res[i][j]=0;
                    vis[i][j] = 1;
                }
            }
        }
        while (!q.isEmpty()) {
            info k = q.remove();
            int i=k.i;
            int j=k.j;
            int curh=k.ht;
            int dir[][]={{-1, 0, 1, 0}, {0, 1, 0, -1}};
            for (int l=0;l<4;l++) {
                int row=i+dir[0][l];
                int col=j+dir[1][l];
                if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new info(row, col, curh+1));
                    res[row][col]=curh+1;
                }
            }
        }
        return res;
    }
}