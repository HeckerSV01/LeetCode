class Solution {
    public int numberOfSubstrings(String s, int k) {
        int freq[]=new int[26];
        int l=0;
        int r=0;
        int res=0;
        while(r<s.length()){
            freq[s.charAt(r)-'a']++;
            while(freq[s.charAt(r)-'a']==k){
                res=res+s.length()-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
}