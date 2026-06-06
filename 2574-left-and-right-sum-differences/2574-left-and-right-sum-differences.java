class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        int temp=sum;
        int right[]=new int[nums.length];
        int left[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            right[i]=temp-nums[i];
            temp=temp-nums[i];
        }
        temp=sum;
        for(int i=nums.length-1;i>=0;i--){
            left[i]=temp-nums[i];
            temp=temp-nums[i];
        }
        for(int i=0;i<nums.length;i++){
            left[i]=Math.abs(left[i]-right[i]);
        }
        return left;
    }
}