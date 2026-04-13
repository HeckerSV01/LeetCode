class Solution {
    int count=0;
    private void backtrack(int a[],int i,int maxor,int curr){
        if(i==a.length){
            if(curr==maxor){
                count++;
            }
            return;
        }
        backtrack(a,i+1,maxor,curr|a[i]);
        backtrack(a,i+1,maxor,curr);
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxor=0;
        for(int k:nums){
            maxor=maxor|k;
        }
        backtrack(nums,0,maxor,0);
        return count;
    }
}