class Solution {
    public int maxProfit(int[] prices) {
        int bp=Integer.MAX_VALUE;
        int maxprof=0;
        for(int i=0;i<prices.length;i++)
        {
           if(prices[i]<bp)
           {
            bp=prices[i];
           }
           else
           {
            maxprof=Math.max(maxprof,prices[i]-bp);
           }
        }
        return maxprof;
    }
}