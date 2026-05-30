class Solution {
    private int solve(int a[],int k){
        int odd=0;
        int l=0;
        int r=0;
        int res=0;
        while(r<a.length){
            if(a[r]%2!=0){
                odd++;
            }
            while(odd>k){
                if(a[l]%2!=0){
                    odd--;
                }
                l++;
            }
            res=res+r-l+1;
            r++;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}