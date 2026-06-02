class Solution {
    private boolean isvowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;        
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int l=0;
        int r=k-1;
        int vowels=0;
        for(int i=l;i<=r;i++){
            if(isvowel(s.charAt(i))){
                vowels++;
            }
        }
        int res=vowels;
        while(r<s.length()-1){
            if(isvowel(s.charAt(l))){
                vowels--;
            }
            l++;
            r++;
            if(isvowel(s.charAt(r))){
                vowels++;
            }
            res=Math.max(res,vowels);
        }
        return res;
    }
}