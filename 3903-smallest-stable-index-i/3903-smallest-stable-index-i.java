class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int j=0;j<=i;j++){
                max=Math.max(max,nums[j]);
            }
            for(int j=i;j<nums.length;j++){
                min=Math.min(min,nums[j]);
            }
            if(max-min<=k){
                return i;
            }
        }
        return -1;
    }
}