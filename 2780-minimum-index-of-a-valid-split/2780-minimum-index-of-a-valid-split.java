class Solution {
    public int[] finddom(List<Integer> a)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.size();i++)
        {
            map.put(a.get(i),map.getOrDefault(a.get(i),0)+1);
        }
        int max=0;
        int freq=-1;
        for(int k:map.keySet())
        {
            if(map.get(k)>freq)
            {
                freq=map.get(k);
                max=k;
            }
        }
        if(freq>a.size()/2)
        {
            return new int[]{max,freq};
        }
        else
        {
            return new int[]{-1,-1};
        }
    }
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        int dom[]=finddom(nums);
        int maxf=dom[1];
        int maxe=dom[0];
        int leftCount=0;
        for(int i=0;i<n-1;i++)
        {
            if(nums.get(i)==maxe)
            {
                leftCount++;
            }
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            int rightCount = maxf - leftCount;
            if (leftCount > leftSize / 2 &&
                rightCount > rightSize / 2) {
                return i;
            }
        }
        return -1;
    }
}