class Solution {
    public int minOperations(int[][] grid, int x) {
        int num=grid.length*grid[0].length;
        if(num==1){
            return 0;
        }
        int rem=grid[0][0]%x;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]%x!=rem){
                    return -1;
                }
                list.add(grid[i][j]);
            }
        }
        int res=0;
        Collections.sort(list);
        if(num%2==0){
            int a=list.get(num/2-1);
            int b=list.get(num/2);
            int res1=0;
            int res2=0;
            for(int i=0;i<num;i++){
                res1=res1+Math.abs(a-list.get(i))/x;
            }
            for(int i=0;i<num;i++){
                res2=res2+Math.abs(b-list.get(i))/x;
            }
            res=Math.min(res1,res2);
        }else{
            int a=list.get(num/2);
            for(int i=0;i<num;i++){
                res=res+Math.abs(a-list.get(i))/x;
            }
        }
        return res;
    }
}