class Solution {
    public String removeDuplicateLetters(String s) {
         int remainfreq[]=new int[26];
        for(int i=0;i<s.length();i++){
            remainfreq[s.charAt(i)-'a']++;
        }
        boolean seen[]=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            remainfreq[s.charAt(i)-'a']--;
            while(!st.isEmpty()&&!seen[s.charAt(i)-'a']&&st.peek()>s.charAt(i)&&remainfreq[st.peek() - 'a'] > 0){
                char p=st.pop();
                seen[p-'a']=!seen[p-'a'];
            }
            if(!seen[s.charAt(i)-'a']){
                st.push(s.charAt(i));
                seen[s.charAt(i)-'a']=true;
            }
        }
        String res="";
        for(char c:st){
            res=res+c;
        }
        return res;
    }
}