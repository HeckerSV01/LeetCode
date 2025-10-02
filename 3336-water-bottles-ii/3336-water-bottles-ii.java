class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int a=numBottles;
        int b=numExchange;
        int res=a;
        while(a>=b)
        {
            a=a-b+1;
            res++;
            b++;
        }
        return res;
    }
}