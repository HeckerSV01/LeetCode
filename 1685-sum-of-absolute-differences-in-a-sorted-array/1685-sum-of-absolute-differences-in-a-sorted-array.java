class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int pref[]=new int[nums.length];
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i]=pref[i-1]+nums[i];
        }
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int prev=0;
            int next=0;
            if(i>0){
                prev=(i)*nums[i]-(pref[i-1]);
            }   
            if(i<nums.length-1){
                next=(pref[nums.length-1]-pref[i])-((nums.length-i-1)*nums[i]);
            }
            res[i]=next+prev;
        }
        return res;
    }
}