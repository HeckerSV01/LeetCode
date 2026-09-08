class c{
    int idx;
    int lastpos;
    public c(int idx,int lastpos){
        this.idx=idx;
        this.lastpos=lastpos;
    }
}
class Solution {
    public int minSwaps(int[][] grid) {
        c last1pos[]=new c[grid.length];
        for(int i=0;i<grid.length;i++){
            int pos=-1;
            for(int j=grid[0].length-1;j>=0;j--){
                if(grid[i][j]==1){
                    pos=j;
                    break;
                }
            }
            last1pos[i]=new c(i,pos);
        }
        int res=0;
        for(int i=0;i<last1pos.length;i++){
            int j=i;
            while(j<last1pos.length&&last1pos[j].lastpos>i){
                j++;
            }
            if(j==grid.length){
                return -1;
            }
            res=res+j-i;
            c temp=last1pos[j];
            while(j>i){
                last1pos[j]=last1pos[j-1];
                j--;
            }
            last1pos[i]=temp;
        }
        return res;
    }
}