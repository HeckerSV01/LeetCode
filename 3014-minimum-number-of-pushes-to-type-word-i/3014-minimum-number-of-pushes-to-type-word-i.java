class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n>=0&&n<=8){
            return n;
        }else if(n>=9&&n<=16){
            return 8+((n-8)*2);
        }else if(n>=17&&n<=24){
            return 8+16+((n-16)*3);
        }else{
            return 8+16+24+((n-24)*4);
        }
    }
}