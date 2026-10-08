class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        List<String> list=new ArrayList<>();
        int start=0;
        for(int i=start;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else{
                count--;
            }
            if(count==0){
                list.add(s.substring(start,i+1));
                start=i+1;
            }
        }
        String res="";
        for(String st: list){
            res+=st.substring(1,st.length()-1);
        }
        return res;
    }
}