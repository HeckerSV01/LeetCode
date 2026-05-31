class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=-1;
        for(int m:nums){
            max=Math.max(max,m);
        }
        int l=0;
        int r=0;
        long res=0;
        int count=0;
        while(r<nums.length){
            if(nums[r]==max){
                count++;
            }
            while(count==k){
                if(count==k){
                    res=res+nums.length-r;                }
                if(nums[l]==max){
                    count--;
                }
                l++;
            }
            r++;
        }
        return res;
    }
}