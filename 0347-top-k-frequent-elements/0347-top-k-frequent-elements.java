class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a, b)->b.getValue()-a.getValue());
        int res[]=new int[k];
        for(int i=0;i<k;i++)
        {
            res[i]=list.get(i).getKey();
        }
        return res;
    }
}