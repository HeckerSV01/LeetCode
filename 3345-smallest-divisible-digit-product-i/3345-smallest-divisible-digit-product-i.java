class Solution {
    private int digprod(int n){
        int k=n;
        int prod=1;
        while(k!=0){
            int temp=k%10;
            prod=prod*temp;
            k=k/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i>=0;i++){
            if(digprod(i)%t==0){
                return i;
            }
        }
        return -1;
    }
}