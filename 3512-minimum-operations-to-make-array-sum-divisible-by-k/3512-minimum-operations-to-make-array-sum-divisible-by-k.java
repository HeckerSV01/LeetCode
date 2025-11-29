class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int n:nums)
        {
            sum=sum+n;
        }
        return sum%k;
    }
}