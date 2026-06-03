class Solution {
    private boolean isAnagram(int sfreq[],int pfreq[]){
        for(int i=0;i<26;i++){
            if(pfreq[i]!=sfreq[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s.length()<p.length()){
            return res;
        }
        int sfreq[]=new int[26];
        int pfreq[]=new int[26];
        for(char c:p.toCharArray()){
            pfreq[c-'a']++;
        }
        int l=0;
        int r=p.length()-1;
        for(int i=l;i<=r;i++){
            sfreq[s.charAt(i)-'a']++;
        }
        if(isAnagram(sfreq,pfreq)){
            res.add(l);
        }
        while(r<s.length()-1){
            sfreq[s.charAt(l)-'a']--;
            l++;
            r++;
            sfreq[s.charAt(r)-'a']++;
            if(isAnagram(sfreq,pfreq)){
                res.add(l);
            }
        }
        return res;
    }
}