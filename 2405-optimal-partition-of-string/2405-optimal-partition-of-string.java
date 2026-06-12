class Solution {
    public int partitionString(String s) {
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                set.clear();
                set.add(s.charAt(i));
                count++;
            }
        }
        return count+1;
    }
}