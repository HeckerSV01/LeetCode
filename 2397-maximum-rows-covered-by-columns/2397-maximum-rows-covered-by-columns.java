class Solution {
    int res=Integer.MIN_VALUE;
    private int getrows(int mat[][],HashSet<Integer> set){
        int count=0;
        for(int i=0;i<mat.length;i++){
            boolean rowcovered=true;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1&&!set.contains(j)){
                    rowcovered=false;
                    break;
                }
            }
            if(rowcovered){
                count++;
            }
        }
        return count;
    }
    private void solve(int mat[][],int n,int i,HashSet<Integer> set){
        if(set.size()==n){
            res=Math.max(res,getrows(mat,set));
            return;
        } 
        if(i==mat[0].length){
            return;
        }
        set.add(i);
        solve(mat,n,i+1,set);
        set.remove(i);
        solve(mat,n,i+1,set);
    }
    public int maximumRows(int[][] matrix, int numSelect) {
        HashSet<Integer> set=new HashSet<>();
        solve(matrix,numSelect,0,set);
        return res;
    }
}