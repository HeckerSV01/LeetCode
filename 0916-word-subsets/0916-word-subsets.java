class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<words2.length;i++){
            HashMap<Character,Integer> temp=new HashMap<>();
            for(char c:words2[i].toCharArray()){
                temp.put(c,temp.getOrDefault(c,0)+1);
            }
            for(char c:temp.keySet()){
                map.put(c,Math.max(temp.get(c),map.getOrDefault(c,0)));
            }
        }
        List<String> res=new ArrayList<>();
        for(String s:words1){
            HashMap<Character,Integer> m=new HashMap<>();
            for(int i=0;i<s.length();i++){
                m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
            }
            boolean check=true;
            for(char c:map.keySet()){
                if(m.getOrDefault(c,0)<map.get(c)){
                    check=false;
                    break;
                }
            }
            if(check){
                res.add(s);
            }
        }
        return res;
    }
}