class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        for(int i=0;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]=grid[i][j-1]+grid[i][j];
            }
        }
        for(int j=0;j<grid[0].length;j++){
            for(int i=1;i<grid.length;i++){
                grid[i][j]=grid[i-1][j]+grid[i][j];
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<=k){
                    count++;
                }
            }
        }
        return count;
    }
}