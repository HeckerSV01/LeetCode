class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=y;i<y+k;i++){
            int p1=x;
            int p2=x+k-1;
            while(p1<p2){
                int temp=grid[p1][i];
                grid[p1][i]=grid[p2][i];
                grid[p2][i]=temp;
                p1++;
                p2--;
            }
        }
        return grid;
    }
}