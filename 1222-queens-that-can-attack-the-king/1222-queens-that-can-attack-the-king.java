class Solution {
    final int dir[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int map[][]=new int[8][8];
        for(int q[]:queens){
            map[q[0]][q[1]]=1;
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<8;i++){
            int r=king[0];
            int c=king[1];
            while(r>=0&&r<8&&c>=0&&c<8){
                r+=dir[i][0];
                c+=dir[i][1];
                if(r>=0&&r<8&&c>=0&&c<8&&map[r][c]==1){
                    res.add(Arrays.asList(r,c));
                    break;
                }
            }
        }
        return res;
    }
}