class Solution {
    int count=0;
    private void backtrack(int grid[][],int i,int j,int empty){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]<0){
            return;
        }
        if(grid[i][j]==2){
            if(empty==0){
                count++;
            }
            return;
        }
        int temp=grid[i][j];
        grid[i][j]=-2;
        backtrack(grid,i+1,j,empty-1);
        backtrack(grid,i-1,j,empty-1);
        backtrack(grid,i,j+1,empty-1);
        backtrack(grid,i,j-1,empty-1);
        grid[i][j]=temp;
    }
    public int uniquePathsIII(int[][] grid) {
        int start[]=new int[2];
        int empty=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start[0]=i;
                    start[1]=j;
                }
                if(grid[i][j]==0){
                    empty++;
                }
            }
        }
        backtrack(grid,start[0],start[1],empty+1);
        return count;
    }
}