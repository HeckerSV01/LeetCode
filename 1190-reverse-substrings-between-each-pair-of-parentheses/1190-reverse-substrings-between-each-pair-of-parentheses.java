class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            st.push(s.charAt(i));
            if(st.peek()==')'){
                st.pop();
                Queue<Character> q=new ArrayDeque<>();
                while(st.peek()!='('){
                    q.offer(st.pop());
                }
                st.pop();
                while(!q.isEmpty()){
                    st.push(q.poll());
                }
            }
            i++;
        }
        String res="";
        for(Character c:st){
            res+=c;
        }
        return res;
    }
}