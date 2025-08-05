class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int k:map.keySet())
        {
            if(map.get(k)>1)
            {
                res.add(k);
            }
        }
        int a[]=new int[2];
        a[0]=res.get(0);
        a[1]=res.get(1);
        return a;
    }
}