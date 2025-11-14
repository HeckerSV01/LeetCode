class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int diff=nums[i]-i;
            map.put(diff,map.getOrDefault(diff,0L)+1);
        }
        long count=0;
        for(Long k:map.values()){
            count=count+k*(k-1)/2;
        }
        return (long)nums.length*(nums.length-1)/2-count;
    }
}