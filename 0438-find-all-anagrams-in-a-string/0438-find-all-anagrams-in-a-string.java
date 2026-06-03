class Solution {
    private boolean isAnagram(String s,int sfreq[],int pfreq[]){
        for(char c:s.toCharArray()){
            if(pfreq[c-'a']!=sfreq[c-'a']){
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
        if(isAnagram(s.substring(l,r+1),sfreq,pfreq)){
            res.add(l);
        }
        while(r<s.length()-1){
            sfreq[s.charAt(l)-'a']--;
            l++;
            r++;
            sfreq[s.charAt(r)-'a']++;
            if(isAnagram(s.substring(l,r+1),sfreq,pfreq)){
                res.add(l);
            }
        }
        return res;
    }
}