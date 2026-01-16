class Solution {
    boolean res=false;
    private void check(int a[][], int val, int i, int j) {
        if(i<0||i>=a.length||j<0||j>=a.length||a[i][j]!=val){
            return;
        }
        if(a[i][j]==(a.length*a.length)-1){
            res=true;
        }
        check(a,val+1,i+2,j+1);
        check(a,val+1,i+2,j-1);
        check(a,val+1,i+1,j+2);
        check(a,val+1,i-1,j+2);
        check(a,val+1,i+1,j-2);
        check(a,val+1,i-1,j-2);
        check(a,val+1,i-2,j+1);
        check(a,val+1,i-2,j-1);
    }
    public boolean checkValidGrid(int[][] grid) {
        check(grid,0,0,0);
        return res;
    }
}