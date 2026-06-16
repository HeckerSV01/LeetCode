class Solution {
    private int backtrack(int grid[][],int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }
        int temp=grid[i][j];
        int max=grid[i][j];
        grid[i][j]=0;
        max=Math.max(max,Math.max(temp+backtrack(grid,i+1,j),Math.max(temp+backtrack(grid,i-1,j),Math.max(temp+backtrack(grid,i,j+1),temp+backtrack(grid,i,j-1)))));
        grid[i][j]=temp;
        return max;
    }
    public int getMaximumGold(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    res=Math.max(res,backtrack(grid,i,j));
                }
            }
        }
        return res;
    }
}