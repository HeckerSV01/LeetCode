class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0;
        for(int n:nums){
            if(n%2==0){
                sum+=n;
            }
        }
        int res[]=new int[queries.length];
        int i=0;
        for(int q[]:queries){
            int num=nums[q[1]];
            int val=q[0];
            if(num%2==0){
                sum-=num;
            }          
            nums[q[1]]+=val;
            if(nums[q[1]]%2==0){
                sum+=nums[q[1]];
            }
            res[i++]=sum;
        }
        return res;
    }
}