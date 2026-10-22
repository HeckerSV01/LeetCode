class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int changesdec=0;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                idx=i;
                break;
            }
        }
        if(nums.length==1){
            return 0;
        }
        int countdec=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                countdec++;
            }
        }
        int countinc=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                countinc++;
            }
        }
        if(countdec==0&&nums[0]<nums[nums.length-1]){
            return 0;
        }
        if((countinc==0)&&nums[0]>nums[nums.length-1]){
            return 1;
        }
        if(countdec==1&&nums[0]>nums[nums.length-1]){
            return Math.min(idx,n-idx+2);
        }
        if(countinc==1&&nums[0]<nums[n-1]){
            return Math.min(n-idx,2+idx);
        }
        return -1;
    }
}