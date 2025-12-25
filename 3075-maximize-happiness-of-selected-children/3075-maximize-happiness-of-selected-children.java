class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n=happiness.length-2;
        long res=happiness[happiness.length-1];
        int i=1;
        while(i<k)
        {
            if(happiness[n]-i<0)
            {
                res=res;
            }
            else
            {
                res=res+happiness[n]-i;
            }
            n--;
            i++;
        }
        return res;
    }
}