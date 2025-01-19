class Solution {
    public int lengthOfLastWord(String s) {
        int len=0;
        String st=s.trim();
        for(int i=st.length()-1;i>=0;i--)
        {
            if(st.charAt(i)!=' ')
            {
               len++;
            }
            else if(st.charAt(i)==' ')
            {
                break;
            }
        }
        return len;
    }
}