class Solution {
    private int count(int n){
        int c=0;
        while(n!=0){
            n=n&n-1;
            c++;
        }
        return c;
    }
    public int minBitFlips(int start, int goal) {
        int k=start^goal;
        return count(k);
    }
}