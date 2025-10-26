class Solution {
    public boolean check(String s1,String s2)
    {
        for(int i=0;i<s1.length();i++)
        {
            if(s1.indexOf(s1.charAt(i))!=s2.indexOf(s2.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list=new ArrayList<>();
        for( String s:words)
        {
            if(check(pattern,s))
            {
                list.add(s);
            }
        }
        return list;
    }
}