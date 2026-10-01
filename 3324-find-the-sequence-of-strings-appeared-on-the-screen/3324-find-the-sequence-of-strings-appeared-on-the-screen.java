class Solution {
    public List<String> stringSequence(String target) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder("a");
        for(char c:target.toCharArray()){
            for(char ch='a';ch<=c;ch++){
                sb.setCharAt(sb.length()-1,ch);
                res.add(sb.toString());
            }
            sb.append("a");
        }
        return res;
    }
}