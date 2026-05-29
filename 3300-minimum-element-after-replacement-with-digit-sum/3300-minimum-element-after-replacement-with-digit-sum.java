class Solution {
    public int minElement(int[] nums) {
        int res=Integer.MAX_VALUE;
        for(int k:nums){
            int sum=0;
            while(k>0){
                int t=k%10;
                sum=sum+t;
                k=k/10;
            }
            res=Math.min(res,sum);
        }
        return res;
    }
}