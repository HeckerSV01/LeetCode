class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st=new Stack<>();
        int idx=0;
        while(idx<s.length)
        {
            st.push(s[idx]);
            idx++;
        }
        int i=0;
        while(!st.isEmpty())
        {
            char curr=st.pop();
            s[i]=curr;
            i++;
        }
    }
}