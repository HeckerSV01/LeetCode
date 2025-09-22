class Solution {
    public int maxFrequencyElements(int[] nums) {
        int a[]=new int[101];
        for(int k:nums)
        {
            a[k]++;
        }
        int max=-1;
        for(int i=0;i<101;i++)
        {
            if(max<a[i])
            {
                max=a[i];
            }
        }
        int count=0;
        for(int i=0;i<101;i++)
        {
            if(a[i]==max)
            {
                count++;
            }
        }
        return max*count;
    }
}