class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l=0;
        int r=0;
        int res=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r])>k){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}