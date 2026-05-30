class Solution {
    private int solve(String answerKey,int k,char c){
        int l=0;
        int r=0;
        int res=-1;
        int f=0;
        while(r<answerKey.length()){
            if(answerKey.charAt(r)==c){
                f++;
            }
            while(f>k){
                if(answerKey.charAt(l)==c){
                    f--;
                }
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(solve(answerKey,k,'F'),solve(answerKey,k,'T'));
    }
}