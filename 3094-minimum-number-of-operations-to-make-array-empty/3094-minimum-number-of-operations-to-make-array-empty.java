class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res=0;
        for(int k:map.keySet())
        {
            if(map.get(k)<2)
            {
                return -1;
            }
            res=res+(map.get(k)+2)/3;
        }
        return res;
    }
}