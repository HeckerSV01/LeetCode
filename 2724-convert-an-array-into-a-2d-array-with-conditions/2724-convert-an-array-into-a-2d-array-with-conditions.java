class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        while(!map.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            List<Integer> keys=new ArrayList<>(map.keySet());
            for(int i:keys)
            {
                if(map.get(i)>0)
                {
                    l.add(i);
                    if(map.get(i)==1)
                    {
                        map.remove(i);
                    }
                    else
                    {
                        map.put(i,map.get(i)-1);
                    }
                }
            }
            res.add(l);
        }
        return res;
    }
}