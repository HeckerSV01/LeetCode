class Solution {
    public int sortPermutation(int[] nums) {
        int res=-1;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                if(res==-1){
                    res=nums[i];
                }else{
                    res&=nums[i];
                }
            }
        }
        return (res==-1)?0:res;
    }
}