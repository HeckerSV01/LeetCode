class Solution {
    public int largestInteger(int[] nums, int k) {
        int l=0;
        int r=0;
        int res[]=new int[51];
        int freq[]=new int[51];
        for(int i=0;i<k;i++){
            freq[nums[i]]++;
            r++;
        }
        for(int i=0;i<51;i++){
            if(freq[i]>0){
                res[i]++;
            }
        }
        while(r<nums.length){
            freq[nums[l]]--;
            l++;
            freq[nums[r]]++;
            r++;
            for(int i=0;i<51;i++){
                if(freq[i]>0){
                    res[i]++;
                }
            }
        }
        for(int i=50;i>=0;i--){
            if(res[i]==1){
                return i;
            }
        }
        return -1;
    }
}