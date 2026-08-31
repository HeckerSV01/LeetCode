class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] freq=new int[101];
        for(int k:nums){
            freq[k]++;
        }
        
        int l=-1;
        int r=-1;
        int curr=-1;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=curr){
                if(curr!=-1){
                    int len=r-l+1;
                    if(len==freq[curr]){
                        res++;
                    }
                }
                l=i;
                r=i;
                curr=nums[i];
            }else{
                r++;
            }
        }
        if(freq[curr]==r-l+1){
            res++;
        }
        return res;
    }
}