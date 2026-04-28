class Solution {
    public String rankTeams(String[] votes) {
        int pos=votes[0].length();
        HashMap<Character,int[]> map=new HashMap<>();
        for(int i=0;i<votes.length;i++){
            for(int j=0;j<votes[i].length();j++){
                map.putIfAbsent(votes[i].charAt(j),new int[pos]);
                map.get(votes[i].charAt(j))[j]++;
            }
        }
        List<Character> list=new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->{
            for(int i=0;i<pos;i++){
                if(map.get(a)[i]!=map.get(b)[i]){
                    return map.get(b)[i]-map.get(a)[i];
                }
            }
            return a-b;
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}