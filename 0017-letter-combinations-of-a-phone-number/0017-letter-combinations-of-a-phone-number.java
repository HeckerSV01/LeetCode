class Solution {
    List<String> res=new ArrayList<>();
    private void fn(String s,HashMap<Character,String> map, int i, StringBuilder sb,List<String> res){
        if(i==s.length()){
            res.add(sb.toString());
            return;
        }
        String st=map.get(s.charAt(i));
        for(char c:st.toCharArray()){
            sb.append(c);
            fn(s,map,i+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        fn(digits,map,0,new StringBuilder(),res);
        return res;
    }
}