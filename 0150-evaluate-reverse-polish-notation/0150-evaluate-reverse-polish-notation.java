class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for(String st:tokens)
        {
            if(st.equals("+")||st.equals("-")||st.equals("*")||st.equals("/"))
            {
                int b=s.pop();
                int a=s.pop();
                int k=0;
                if(st.equals("+"))
                {
                    k=a+b;
                }
                if(st.equals("-"))
                {
                    k=a-b;
                }
                if(st.equals("*"))
                {
                    k=a*b;
                }
                if(st.equals("/"))
                {
                    k=a/b;
                }
                s.push(k);
            }           
            else
            {
                s.push(Integer.parseInt(st));
            }
        }
        return s.peek();
    }
}