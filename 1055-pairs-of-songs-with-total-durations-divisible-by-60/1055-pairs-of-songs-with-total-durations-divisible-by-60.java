class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int mod[]=new int[60];
        for(int i=0;i<time.length;i++)
        {
            mod[time[i]%60]++;
        }
        long res=0;
        for(int i=1;i<30;i++)
        {
            res=res+(long)(mod[i]*mod[60-i]);
        }
        long zero = mod[0];
        long thirty = mod[30];
        res += zero * (zero - 1) / 2;
        res += thirty * (thirty - 1) / 2;
        return (int) res;
    }
}