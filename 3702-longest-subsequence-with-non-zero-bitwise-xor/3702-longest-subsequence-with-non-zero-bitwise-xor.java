class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int notzero=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
            if(nums[i]!=0){
                notzero++;
            }
        }
        if(xor!=0){
            return nums.length;
        }else{
            if(notzero>0){
                return nums.length-1;
            }else{
                return 0;
            }
        }
    }
}