class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int st=0;
        int en=nums.length-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if((mid>0&&nums[mid]!=nums[mid-1])&&(mid<nums.length-1&&nums[mid]!=nums[mid+1])){
                return nums[mid];
            }
            else if((mid%2==1&&mid>0&&nums[mid]==nums[mid-1])||(mid%2==0&&mid<nums.length-1&&nums[mid]==nums[mid+1])){
                st=mid+1;
            }else{
                en=mid-1;
            }
        }
        return nums[st];
    }
}