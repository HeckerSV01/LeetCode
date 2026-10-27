class Solution {
    public int countCollisions(String dir) {
        Stack<Character> st=new Stack<>();
        int count=0;
        for(int i=0;i<dir.length();i++){
            char c=dir.charAt(i);
            if(c=='R'){
                st.push('R');
            }else if(c=='S'){
                while(!st.isEmpty()&&st.peek()=='R'){
                    count++;
                    st.pop();
                }
                st.push('S');
            }else{
                if(st.isEmpty()){
                    st.push('L');
                }else if(st.peek()=='R'){
                    count+=2;
                    st.pop();
                    while(!st.isEmpty()&&st.peek()=='R'){
                        st.pop();
                        count++;
                    }
                    st.push('S');
                }else if(st.peek()=='S'){
                    count++;
                }else{
                    st.push('L');
                }
            }
        }
        return count;
    }
}