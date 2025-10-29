class Solution {
    public int tupleSameProduct(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int count=0;
        for(int k:map.keySet())
        {
            if(map.get(k)>1)
            {
                count=count+4*map.get(k)*(map.get(k)-1);
            }
        }
        return count;
    }
}