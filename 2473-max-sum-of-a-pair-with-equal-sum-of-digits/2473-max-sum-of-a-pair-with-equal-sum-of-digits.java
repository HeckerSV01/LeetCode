class Solution {
    public int sumofdig(int n)
    {
        int k=n;
        int sum=0;
        while(k>0)
        {
            int a=k%10;
            sum=sum+a;
            k=k/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int sum=sumofdig(nums[i]);
            if(!map.containsKey(sum))
            {
                map.put(sum,new ArrayList<>());
            }
            map.get(sum).add(nums[i]);
        }
        int max=-1;
        for(int k:map.keySet())
        {
            if(map.get(k).size()>1)
            {
                List<Integer> list=map.get(k);
                Collections.sort(list);
                int sum=list.get(list.size()-1)+list.get(list.size()-2);
                if(sum>max)
                {
                    max=sum;
                }
            }
        }
        return max;
    }
}