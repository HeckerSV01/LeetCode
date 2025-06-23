class Solution {
    public int[] shuffle(int[] nums, int n) {
        int a1[]=new int[n];
        int a2[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a1[i]=nums[i];
            a2[i]=nums[i+n];
        }
        int res[]=new int[n*2];
        int l=0;
        int m=0;
        for(int i=0;i<n*2;i++)
        {
            if(i%2==0)
            {
                res[i]=a1[l++];
            }
            else
            {
                res[i]=a2[m++];
            }
        }
        return res;
    }
}