class Solution {
    public String smallestNumber(String pattern) {
       StringBuilder sb=new StringBuilder();
       Stack<Integer> st=new Stack<>();
       int num=1;
       for(int i=0;i<pattern.length();i++){
        if(pattern.charAt(i)=='I'){
            sb.append(num);
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            num++;
        }else{
            st.push(num);
            num++;
        }
       } 
       st.push(num);
       while(!st.isEmpty()){
        sb.append(st.pop());
       }
       return sb.toString();
    }
}