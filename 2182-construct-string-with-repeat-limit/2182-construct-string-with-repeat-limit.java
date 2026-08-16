class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
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
                sb.repeat((char)(i+97),rep);
                }else{
                    sb.append((char)(i+97));
                    freq[i]=freq[i]-1;
                    noreps=true;
                    i=idx+1;
                } 
            }
        }
        return sb.toString();
    }
}