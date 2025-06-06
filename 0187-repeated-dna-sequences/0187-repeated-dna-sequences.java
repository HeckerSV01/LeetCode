class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> s1=new HashSet<>();
        HashSet<String> s2=new HashSet<>();
        for(int i=0;i<s.length()-9;i++)
        {
            String st=s.substring(i,i+10);
            if(!s1.contains(st))
            {
                s1.add(st);
            }
            else
            {
                s2.add(st);
            }
        }
        return new ArrayList(s2);
    }
}