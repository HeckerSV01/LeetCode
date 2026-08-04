class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
            {
                set.add(nums[i]);
            }
        List<Integer> res=new ArrayList<>();
        for(int i=nums[0];i<nums[nums.length-1];i++)
            {
                if(!set.contains(i))
                {
                    res.add(i);
                }
            }
        return res;
    }
}