class Solution {
    public boolean checkGoodInteger(int n) {
        int sum=0;
        int sqsum=0;
        int k=n;
        while(k>0){
            int t=k%10;
            sum=sum+t;
            sqsum=sqsum+t*t;
            k=k/10;
        }
        return sqsum-sum>=50;
    }
}