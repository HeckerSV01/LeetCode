class Solution {
    public int minSwaps(String s) {
        int open=0;
        int close=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                open++;
            }else{
                close++;
            }
            if(close>open){
                res++;
                open++;
                close--;
            }
        }
        return res;
    }
}