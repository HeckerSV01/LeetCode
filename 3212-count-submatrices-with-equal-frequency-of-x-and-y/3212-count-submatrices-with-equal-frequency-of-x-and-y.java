class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int x[][]=new int[grid.length][grid[0].length];
        int y[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]=='X'){
                x[i][0]=1;
            }else if(grid[i][0]=='Y'){
                y[i][0]=1;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                if(grid[i][j]=='X'){
                    x[i][j]=x[i][j-1]+1;
                    y[i][j]=y[i][j-1];
                }
                if(grid[i][j]=='Y'){
                    y[i][j]=y[i][j-1]+1;
                    x[i][j]=x[i][j-1];
                }
                if(grid[i][j]=='.'){
                    y[i][j]=y[i][j-1];
                    x[i][j]=x[i][j-1];
                }
            }
        }
        for(int j=0;j<grid[0].length;j++){
            for(int i=1;i<grid.length;i++){
                x[i][j]=x[i][j]+x[i-1][j];
                y[i][j]=y[i][j]+y[i-1][j];
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(x[i][j]!=0&&x[i][j]==y[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}