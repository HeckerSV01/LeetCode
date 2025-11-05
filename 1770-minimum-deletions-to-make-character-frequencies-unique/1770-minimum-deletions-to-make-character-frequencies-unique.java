class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        int res=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]==0)
            {
                continue;
            }
            while(set.contains(freq[i]))
            {
                freq[i]--;
                res++;
            }
            if(freq[i]>0)
            {
                set.add(freq[i]);
            }
        }
        return res;
    }
}