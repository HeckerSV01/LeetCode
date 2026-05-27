class Solution {
    public int numberOfSpecialChars(String word) {
        int caps[]=new int[26];
        int small[]=new int[26];
        Arrays.fill(caps,-1);
        Arrays.fill(small,-1);
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='a'&&c<='z'){
                small[c-'a']=i;
            }
        }
        for(int i=word.length()-1;i>=0;i--){
            char c=word.charAt(i);
            if(c>='A'&&c<='Z'){
                caps[c-'A']=i;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(small[i]!=-1&&caps[i]!=-1&&small[i]<caps[i]){
                count++;
            }
        }
        return count;
    }
}