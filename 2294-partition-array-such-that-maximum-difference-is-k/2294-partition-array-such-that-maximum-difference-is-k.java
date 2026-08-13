class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int idx=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-nums[idx]>k){
                res++;
                idx=i;
            }
        }
        return res+1;
    }
}