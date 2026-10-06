class Solution {
    final long MOD=1000000007L;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int q[]:queries){
            for(int i=q[0];i<=q[1];i+=q[2]){
                nums[i]=(int)((1L*nums[i]*q[3])%MOD);
            }
        }
        int res=0;
        for(int i:nums){
            res^=i;
        }
        return res;
    }
}