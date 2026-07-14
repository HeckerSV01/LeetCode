class Solution {
    private boolean check(String s1,String s2){
        int ptr1=0;
        int ptr2=0;
        while(ptr1<s1.length()&&ptr2<s2.length()){
            if(s1.charAt(ptr1)==s2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                ptr2++;
            }
        }
        return (ptr1==s1.length());
    }
    public String findLongestWord(String s, List<String> dictionary) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<dictionary.size();i++){
            if(check(dictionary.get(i),s)){
                list.add(dictionary.get(i));
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