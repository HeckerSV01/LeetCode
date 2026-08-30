class Solution {
    public int minimumDeletions(int[] nums) {
        int i1=0;
        int i2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[i2]){
                i2=i;
            }
            if(nums[i]<nums[i1]){
                i1=i;
            }
        }
        if(i1<i2){
            return Math.min(i2+1,Math.min(nums.length-i1,i1+1+nums.length-i2));
        }else{
            return Math.min(i1+1,Math.min(nums.length-i2,i2+1+nums.length-i1));
        }
    }
}