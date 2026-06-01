class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int k=1;
        int res=0;
        for(int i=cost.length-1;i>=0;i--){
            if(3*k-1==cost.length-i-1){
                k++;
                continue;
            }
            res=res+cost[i];
        }
        return res;
    }
}