class Solution {
    public int characterReplacement(String s, int k) {
        int res=-1;
        int l=0;
        int r=0;
        int maxFreq=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(r)));
            while(r-l+1-maxFreq>k){
                char c=s.charAt(l);
                if(map.get(c)>1){
                    map.put(c,map.get(c)-1);
                }else{
                    map.remove(c);
                }
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}