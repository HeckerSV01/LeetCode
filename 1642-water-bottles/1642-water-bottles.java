class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int b=numBottles;
        int res=numBottles;
        while(b>=numExchange)
        {
            int n=b/numExchange;
            int r=b%numExchange;
            res=res+n;
            b=n+r;
        }
        return res;
    }
}