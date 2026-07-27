class Solution {
    public int maxProduct(int[] nums) {
        int res=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                res=Math.max(res,(nums[i]-1)*(nums[j]-1));
            }
        }
        return res;
    }
}