class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set=new HashSet<>();
        for(int k:banned)
        {
            set.add(k);
        }
        int i=1;
        int sum=0;
        int res=0;
        while(i<=n)
        {
            if(!set.contains(i))
            {
                if(sum+i>maxSum)
                {
                    break;
                }
                sum=sum+i;
                res++;
            }
            i++;
        }
        return res;
    }
}