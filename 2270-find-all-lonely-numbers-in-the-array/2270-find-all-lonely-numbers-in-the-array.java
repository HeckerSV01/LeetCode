class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int k:nums)
        {
            map.put(k,map.getOrDefault(k,0)+1);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i])==1)
            {
                if(!map.containsKey(nums[i]+1)&&!map.containsKey(nums[i]-1))
                {
                    res.add(nums[i]);
                }
            }
        }
        return res;
    }
}