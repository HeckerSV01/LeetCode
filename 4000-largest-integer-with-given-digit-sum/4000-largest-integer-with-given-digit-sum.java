class Solution {
    private int sum(int n){
        int k=n;
        int sum=0;
        while(k>0){
            int t=k%10;
            sum=sum+t;
            k=k/10;
        }
        return sum;
    }
    public int largestInteger(int n, int s) {
        int k=(int)Math.pow(10,n)-1;
        for(int i=k;i>=0;i--){
            if(sum(i)==s){
                return i;
            }
        }
        return -1;
    }
}