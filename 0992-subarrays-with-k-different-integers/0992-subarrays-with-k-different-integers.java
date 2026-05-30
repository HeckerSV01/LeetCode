class Solution {
    private int solve(int nums[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int res=0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                if(map.get(nums[l])>1){
                    map.put(nums[l],map.get(nums[l])-1);
                }else{
                    map.remove(nums[l]);
                }
                l++;
            }
            res=res+r-l+1;
            r++;
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}