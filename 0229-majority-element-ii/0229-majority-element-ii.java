class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> key=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int count=map.get(nums[i]);
                count++;
                map.put(nums[i],count);
            }
            else
            {
                map.put(nums[i],1);
                key.add(nums[i]);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<key.size();i++)
        {
            if(map.get(key.get(i))>(nums.length/3))
            {
                res.add(key.get(i));
            }
        }
        return res;
    }
}