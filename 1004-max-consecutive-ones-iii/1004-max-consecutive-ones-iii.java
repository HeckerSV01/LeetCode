class Solution {
    public int longestOnes(int[] nums, int k) {
        int a[]=new int[2];
        int l=0;
        int r=0;
        int res=-1;
        for(r=0;r<nums.length;r++){
            a[nums[r]]++;
            while(a[0]>k){
                a[nums[l]]--;
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}