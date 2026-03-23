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
            int left=-1;
            int right=-1;
            if(mid>0&&nums[mid-1]==nums[mid]){
                left=mid-1;
            }
            if(mid<nums.length-1&&nums[mid]==nums[mid+1]){
                right=mid+1;
            }
            boolean singleonleft=false;
            if(left!=-1){
                if(left%2==0){
                    singleonleft=false;
                }else{
                    singleonleft=true;
                }
            }else{
                if(right%2==0){
                    singleonleft=true;
                }else{
                    singleonleft=false;
                }
            }
            if(singleonleft){
                en=mid-1;
            }else{
                st=mid+1;
            }
        }
        return nums[en];
    }
}