class Solution {
    public char kthCharacter(int k) {
        String st="a";
        while(st.length()<k)
        {
            StringBuilder sb=new StringBuilder();
           for(int i=0;i<st.length();i++)
           {
            if(st.charAt(i)=='z')
            {
               sb.append('a');
            }
            else
            {
                sb.append((char)((int)st.charAt(i)+1));
            }
           }
           st+=sb.toString();
        }
        return st.charAt(k-1);
    }
}