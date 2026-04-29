class Solution {
    public int maxProduct(String[] words) {
        HashMap<Integer,HashSet<Character>> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.putIfAbsent(i,new HashSet<>());
            for(int j=0;j<words[i].length();j++){
                map.get(i).add(words[i].charAt(j));
            }
        }
        int res=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                boolean check=true;
                for(char c:map.get(i)){
                    if(map.get(j).contains(c)){
                        check=false;
                    }
                }
                if(check){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}