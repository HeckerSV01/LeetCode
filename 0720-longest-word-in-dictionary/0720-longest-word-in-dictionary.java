class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set=new HashSet<>();
        for(String s: words){
            set.add(s);
        }
        List<String> list=new ArrayList<>();
        for(String s:words){
            boolean prefPresent=true;
            for(int i=0;i<s.length();i++){
                if(!set.contains(s.substring(0,i+1))){
                    prefPresent=false;
                    break;
                }
            }
            if(prefPresent){
                list.add(s);
            }
        }
        if(list.size()==0){
            return "";
        }
        Collections.sort(list,(a,b)->{
            if(a.length()==b.length()){
                return b.compareTo(a);
            }else{
                return a.length()-b.length();
            }
        });
        return list.get(list.size()-1);
    }
}