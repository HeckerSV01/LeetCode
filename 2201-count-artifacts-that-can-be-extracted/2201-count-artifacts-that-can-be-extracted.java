class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean grid[][]=new boolean[n][n];
        for(int k[]:dig){
            grid[k[0]][k[1]]=true;
        }
        int count=0;
        for(int k[]:artifacts){
            int i1=k[0];
            int j1=k[1];
            int i2=k[2];
            int j2=k[3];
            boolean canget=true;
            for(int i=i1;i<=i2;i++){
                for(int j=j1;j<=j2;j++){
                    if(!grid[i][j]){
                        canget=false;
                        break;
                    }
                }
            }
            if(canget){
                count++;
            }else{
                continue;
            }
        }
        return count;
    }
}