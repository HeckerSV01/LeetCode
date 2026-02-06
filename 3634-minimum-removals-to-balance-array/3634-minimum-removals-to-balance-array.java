class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int j=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(j<i){
                j=i;
            }
            while(j<nums.length&&(long)nums[i]*k>=nums[j]){
                j++;
            }
            max=Math.max(max,j-i);
        }
        return nums.length-max;
    }
}