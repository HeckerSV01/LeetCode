class Solution {
    private boolean check(int n,int i){
        int sum=0;
        int x=n;
        while(x>0){
            sum=sum+x%10;
            x=x/10;
        }
        return sum==i;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(check(nums[i],i)){
                return i;
            }
        }
        return -1;
    }
}