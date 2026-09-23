class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int k:nums){
            sum=sum+k;
        }
        int target=sum-x;
        if(target<0){
            return -1;
        }
        int l=0;
        int r=0;
        int winsum=0;
        int res=Integer.MIN_VALUE;
        while(r<nums.length){
            winsum=winsum+nums[r];
            while(winsum>target){
                winsum=winsum-nums[l];
                l++;
            }
            if(winsum==target){
                res=Math.max(res,r-l+1);
            }
            r++;
        }
        if(res==Integer.MIN_VALUE){
            return -1;
        }
        return nums.length-res;
    }
}