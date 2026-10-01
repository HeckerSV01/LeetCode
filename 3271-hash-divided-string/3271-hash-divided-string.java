class Solution {
    public String stringHash(String s, int k) {
        int n=s.length();
        List<String> list=new ArrayList<>();
        for(int i=0;i<s.length();i+=k){
            list.add(s.substring(i,i+k));
        }
        int i=0;
        String res="";
        for(String t:list){
            int sum=0;
            for(char c:t.toCharArray()){
                sum+=c-'a';
            }
            int rem=sum%26;
            res+=(char)('a'+rem);
        }
        return res;
    }
}