class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        String res="";
        boolean noreps=true;
        int idx=26;
        for(int i=25;i>=0;i--){
            if(freq[i]>0){
                if(noreps){
                    int rep=Math.min(repeatLimit,freq[i]);
                if(freq[i]>repeatLimit){
                    freq[i]=freq[i]-rep;
                    noreps=false;
                    idx=i;
                }else{
                    freq[i]=0;
                    noreps=true;
                }
                res=res+String.valueOf((char)(i+97)).repeat(rep);
                }else{
                    res=res+String.valueOf((char)(i+97));
                    freq[i]=freq[i]-1;
                    noreps=true;
                    i=idx+1;
                } 
            }
        }
        return res;
    }
}