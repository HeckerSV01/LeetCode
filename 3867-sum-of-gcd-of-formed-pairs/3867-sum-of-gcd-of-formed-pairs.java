class Solution {
    private int gcd(int a,int b){
        while(b>0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int maxPrefgcd[]=new int[nums.length];
        int curMax=nums[0];
        maxPrefgcd[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            curMax= Math.max(curMax,nums[i]);
            maxPrefgcd[i]=gcd(curMax,nums[i]);
        }
        Arrays.sort(maxPrefgcd);
        long res=0;
        for(int i=0;i<nums.length/2;i++){
            res=res+gcd(maxPrefgcd[i],maxPrefgcd[nums.length-i-1]);
        }
        return res;
    }
}