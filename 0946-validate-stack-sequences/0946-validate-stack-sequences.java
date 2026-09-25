class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int idx2=0;
        for(int val:pushed){
            st.push(val);
            while(!st.isEmpty()&&idx2<popped.length&&st.peek()==popped[idx2]){
                st.pop();
                idx2++;
            }
        }
        return idx2==popped.length;
    }
}