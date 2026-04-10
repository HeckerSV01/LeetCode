class Solution {
     private int count(int n){
        int c=0;
        while(n!=0){
            n=n&n-1;
            c++;
        }
        return c;
    }
    public int hammingDistance(int x, int y) {
        int k=x^y;
        return count(k);
    }
}