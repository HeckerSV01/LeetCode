class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==0){
                for(int j=0;j<n;j++){
                    grid[i][j]=grid[i][j]^1;
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            int count1=0;
            for(int j=0;j<m;j++){
                if(grid[j][i]==1){
                    count1++;
                }
            }
            if(count1<=m/2){
                for(int j=0;j<m;j++){
                    grid[j][i]=grid[j][i]^1;
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            String s="";
            for(int j=0;j<n;j++){
                s=s+Integer.toString(grid[i][j]);
            }
            res=res+Integer.parseInt(s,2);
        }
        return res;
    }
}