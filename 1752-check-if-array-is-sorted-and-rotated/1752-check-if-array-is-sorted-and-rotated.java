class Solution {
    public boolean check(int[] nums) {
        int dips=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                dips++;
            }
        }
        if(dips==0&&nums[0]<=nums[nums.length-1]){
            return true;
        }
        if(dips==1&&nums[0]>=nums[nums.length-1]){
            return true;
        }
        return false;
    }
}