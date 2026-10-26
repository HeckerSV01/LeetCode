class Solution {
    public List<String> partitionString(String s) {
        List<String> res=new ArrayList<>();
        LinkedHashSet<String> set=new LinkedHashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(set.contains(sb.toString())){
                continue;
            }else{
                set.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        for(String st:set){
            res.add(st);
        }
        return res;
    }
}