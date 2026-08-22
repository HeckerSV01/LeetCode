class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int k=n;
        while(k!=0){
            int temp=k%10;
            sum=sum+temp;
            prod=prod*temp;
            k=k/10;
        }
        return n%(sum+prod)==0;
    }
}