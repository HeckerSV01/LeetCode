class Solution {
    public int majorityElement(int[] nums) {
        int candidate=-1;
        int votes=0;
        for(int i=0;i<nums.length;i++){
            if(votes==0||candidate==-1){
                candidate=nums[i];
                votes=1;
            }else if(nums[i]==candidate){
                votes++;
            }else{
                votes--;
            }
        }
        return candidate;
    }
}