class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==x)
            {
                list.add(i);
            }
        }
        int res[]=new int[queries.length];
        int i=0;
        for(int k:queries)
        {
            if(list.size()<k)
            {
                res[i++]=-1;
            }
            else
            {
                res[i++]=list.get(k-1);
            }
        }
        return res;
    }
}