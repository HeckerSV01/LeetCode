class Solution {
    private boolean backtrack(StringBuilder cur,StringBuilder next,int i,HashMap<String,List<Character>> map){
        if(cur.length()==1){
            return true;
        }
        if(i==cur.length()-1){
            return backtrack(next,new StringBuilder(),0,map);
        }
        String str=cur.substring(i,i+2);
        if(map.get(str)==null){
            return false;
        }
        for(char c:map.get(str)){
            next.append(c);
            if(backtrack(cur,next,i+1,map)){
                return true;
            }
            next.deleteCharAt(next.length()-1);
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String,List<Character>> map=new HashMap<>();
        for(String s:allowed){
            String key=s.substring(0,2);
            char value=s.charAt(2);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(value);
        }
        return backtrack(new StringBuilder(bottom),new StringBuilder(),0,map);
    }
}