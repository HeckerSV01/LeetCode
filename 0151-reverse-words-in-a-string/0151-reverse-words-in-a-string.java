class Solution {
    public String reverseWords(String s) {
        Stack<String> st=new Stack<>();
        int i=0;
        while(i<s.length())
        {
            if(i<s.length()&&s.charAt(i)==' ')
            {
                i++;
            }
            else
            {
                StringBuilder sb=new StringBuilder();
                while(i<s.length()&&s.charAt(i)!=' ')
                {
                    sb.append(s.charAt(i));
                    i++;
                }
                st.push(sb.toString());
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
        {
            ans.append(st.pop());
            if(!st.isEmpty())
            {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}