class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res=new ArrayList<>();
        for(int j=0;j<words.length;j++)
        {
            for(int i=0;i<words[j].length();i++)
            {
                if(words[j].charAt(i)==x)
                {
                    res.add(j);
                    break;
                }
            }
        }
        return res;
    }
}