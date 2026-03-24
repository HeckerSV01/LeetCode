class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int st=0;
        int en=nums.length-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if(mid>0&&mid<nums.length-1&&nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid<nums.length-1&&nums[mid+1]>nums[mid]){
                st=mid+1;
            }else{
                en=mid-1;
            }
        }
        return -1;
    }
}