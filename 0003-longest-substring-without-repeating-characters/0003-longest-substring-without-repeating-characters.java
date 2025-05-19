class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int len=0;
        int ptr=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            while(set.contains(ch))
            {
                set.remove(s.charAt(ptr));
                ptr++;
            }
            set.add(ch);
            len=Math.max(len,i-ptr+1);
        }
        return len;
    }
}