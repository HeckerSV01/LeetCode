class Solution {
    public int bs(int a[],long target,int m)
    {
        int st=0;
        int en=a.length-1;
        while(st<=en)
        {
            int mid=(st+en)/2;
            if((long)a[mid]*m<target)
            {
                st=mid+1;
            }
            else 
            {
                en=mid-1;
            }
        }
        return st;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int res[]=new int[spells.length];
        for(int i=0;i<spells.length;i++)
        {
            int idx=bs(potions,success,spells[i]);
            res[i]=potions.length-idx;
        }
        return res;
    }
}