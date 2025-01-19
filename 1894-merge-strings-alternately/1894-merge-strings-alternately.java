class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder st=new StringBuilder();
        for(int i=0;i<Math.min(word1.length(),word2.length());i++)
        {
           st.append(word1.charAt(i));
           st.append(word2.charAt(i));
        }
        if(word1.length()==word2.length())
        {
            return st.toString();
        }
        else if(word1.length()>word2.length())
        {
            st.append(word1.substring(word2.length()));
            return st.toString();
        }
        else
        {
            st.append(word2.substring(word1.length()));
            return st.toString();
        }
    }
}