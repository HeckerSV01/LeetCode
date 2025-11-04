class Solution {
    public int cal(String s)
    {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0)
            {
                return freq[i];
            }
        }
        return 0;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int freqq[]=new int[queries.length];
        int freqw[]=new int[words.length];
        for(int i=0;i<queries.length;i++)
        {
            freqq[i]=cal(queries[i]);
        }
        for(int i=0;i<words.length;i++)
        {
            freqw[i]=cal(words[i]);
        }
        Arrays.sort(freqw);
        int res[]=new int[queries.length];
        for(int i=0;i<freqq.length;i++)
        {
            int left=0,right=freqw.length;
            while(left<right) {
                int mid=left+(right-left)/2;
                if(freqw[mid]<=freqq[i]) 
                {
                    left=mid+1;
                } 
                else
                {
                    right=mid;
                }
            }
            res[i]=freqw.length-left;
        }
        return res;
    }
}