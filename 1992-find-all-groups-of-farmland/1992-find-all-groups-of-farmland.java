class Solution {
    int fr;
    int fc;
    private void dfs(int a[][], int vis[][], int i, int j, int m, int n){
        vis[i][j]=1;
        int dir[][] = { {0, 0, 1, -1}, {-1, 1, 0, 0} };
        for (int k=0;k<4;k++){
            int r=i+dir[0][k];
            int c=j+dir[1][k];
            if(r>=0&&r<m&&c>=0&&c<n&&a[r][c]==1&&vis[r][c]==0){
                dfs(a,vis,r,c,m,n);
                fr=Math.max(fr,r);
                fc=Math.max(fc,c);
            }
        }
    }

    public int[][] findFarmland(int[][] land) {
        int m=land.length;
        int n=land[0].length;
        int vis[][]=new int[m][n];
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==1&&vis[i][j]==0){
                    fr=i;
                    fc=j;
                    dfs(land,vis,i,j,m,n);
                    res.add(new int[]{i,j,fr,fc});
                }
            }
        }
        int arr[][]=new int[res.size()][4];
        for(int i=0;i<res.size();i++){
            for(int j=0;j<4;j++){
                arr[i][j]=res.get(i)[j];
            }
        }
        return arr;
    }
}