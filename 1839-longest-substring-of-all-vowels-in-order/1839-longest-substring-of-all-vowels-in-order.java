class Solution {
    public int longestBeautifulSubstring(String word) {
        int l=0;
        int r=1;
        int res=0;
        HashSet<Character> set=new HashSet<>();
        set.add(word.charAt(0));
        while(r<word.length()){
            if(word.charAt(r-1)<=word.charAt(r)){
                set.add(word.charAt(r));
                if(set.size()==5){
                    res=Math.max(res,r-l+1);
                }
                r++;
            }else{
                set.clear();
                l=r;
                set.add(word.charAt(l));
                r++;
            }
        }
        return res;
    }
}