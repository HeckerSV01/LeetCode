class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int k=2;k<nums.length;k++){
            int i=0;
            int j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    res=res+(j-i);
                    j--;
                }else{
                    i++;
                }
            }
        }
        return res;
    }
}