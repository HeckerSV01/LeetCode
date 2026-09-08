class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int res[]=new int[3];
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0]<=target[0]&&triplets[i][1]<=target[1]&&triplets[i][2]<=target[2]){
                res[0]=Math.max(res[0],triplets[i][0]);
                res[1]=Math.max(res[1],triplets[i][1]);
                res[2]=Math.max(res[2],triplets[i][2]);
            }
        }
        return Arrays.equals(res,target);
    }
}