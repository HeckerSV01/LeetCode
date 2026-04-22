class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<dictionary.length;j++){
                int count=0;
                for(int k=0;k<queries[i].length();k++){
                    if(queries[i].charAt(k)!=dictionary[j].charAt(k)){
                        count++;
                    }
                }
                if(count<=2){
                    res.add(queries[i]);
                    break;
                }
            }
        }
        return res;
    }
}