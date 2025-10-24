class Solution {
    public void backtrack(String a[],int idx,List<String> temp,List<List<String>> subsets)
    {
        if(idx>=a.length)
        {
            subsets.add(new ArrayList<>(temp));
            return;
        }
        temp.add(a[idx]);
        backtrack(a,idx+1,temp,subsets);
        temp.remove(temp.size()-1);
        backtrack(a,idx+1,temp,subsets);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        List<List<String>> subsets=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        backtrack(words,0,temp,subsets);
        int freq[]=new int[26];
        for(char c:letters)
        {
            freq[c-'a']++;
        }
        int maxscore=0;
        for(List<String> k:subsets)
        {
            int freqsub[]=new int[26];
            for(String s:k)
            {
                for(char c:s.toCharArray())
                {
                    freqsub[c-'a']++;
                }
            }
            int sum=0;
            boolean valid=true;
            for(int i=0;i<26;i++)
            {
                if(freqsub[i]>freq[i])
                {
                    valid=false;
                    break;
                }
                else
                {
                    sum=sum+score[i]*freqsub[i];
                }
            }
            if(valid)
            {
                maxscore=Math.max(maxscore,sum);
            }
        }
        return maxscore;
    }
}