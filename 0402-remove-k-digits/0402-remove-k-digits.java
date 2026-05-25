class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return new String("0");
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty()&&k>0&&st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        List<Character> list=new ArrayList<>(st);
        StringBuilder sb=new StringBuilder();
        for(char c:list){
            sb.append(c);
        }
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return (sb.length()==0)?"0":sb.toString();
    }
}