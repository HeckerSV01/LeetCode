class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[]=new int[26];
        int maxfreq=0;
        int l=0;
        int r=0;
        int res=0;
        while(r<s.length()){
            freq[s.charAt(r)-'a']++;
            while(freq[s.charAt(r)-'a']>2){
                freq[s.charAt(l)-'a']--;
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}