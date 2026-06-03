class Solution {
    public int longestBeautifulSubstring(String word) {
        int l=0;
        int r=1;
        int res=0;
        int unique=1;
        while(r<word.length()){
            if(word.charAt(r-1)<=word.charAt(r)){
                if(word.charAt(r-1)<word.charAt(r)){
                    unique++;
                }
                if(unique==5){
                    res=Math.max(res,r-l+1);
                }
                r++;
            }else{
                l=r;
                unique=1;
                r++;
            }
        }
        return res;
    }
}