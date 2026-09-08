class Solution {
    public int countCommas(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            if(i>=1000){
                res++;
            }
        }
        return res;
    }
}