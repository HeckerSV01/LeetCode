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
                String str="";
                while(i<s.length()&&s.charAt(i)!=' ')
                {
                    str=str+s.charAt(i);
                    i++;
                }
                st.push(str);
            }
        }
        String ans="";
        while(!st.isEmpty())
        {
            ans=ans+st.pop();
            if(!st.isEmpty())
            {
                ans=ans+" ";
            }
        }
        return ans;
    }
}