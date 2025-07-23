class Solution {
    int res=0;
    public String findandremove(String st,String s,int score)
    {
        char x=s.charAt(0);
        char y=s.charAt(1);
        Stack<Character> stack=new Stack<>();
        for(char c:st.toCharArray())
        {
            if(!stack.isEmpty()&&stack.peek()==x&&c==y)
            {
                stack.pop();
                res=res+score;
            }
            else
            {
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack)
        {
            sb.append(c);
        }
        return sb.toString();
    }
    public int maximumGain(String s, int x, int y) {
        if(x>=y)
        {
            s=findandremove(s,"ab",x);
            s=findandremove(s,"ba",y);
        }
        else
        {
            s=findandremove(s,"ba",y);
            s=findandremove(s,"ab",x);
        }
        return res;
    }
}