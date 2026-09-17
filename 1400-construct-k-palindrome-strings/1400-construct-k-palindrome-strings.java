class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int oddcount=0;
        int evencount=0;
        for(Character i:map.keySet()){
            if(map.get(i)%2==0){
                evencount++;
            }else{
                oddcount++;
            }
        }
        if(oddcount>k){
            return false;
        }
        return true;
    }
}