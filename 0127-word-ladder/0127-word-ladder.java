class pair{
    String s;
    int dis;
    public pair(String s,int dis)
    {
        this.s=s;
        this.dis=dis;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        Queue<pair> q=new LinkedList<>();
        for(String s:wordList)
        {
            set.add(s);
        }
        if(!set.contains(endWord))
        {
            return 0;
        }
        String st=beginWord;
        q.add(new pair(st,1));
        set.remove(st);
        while(!q.isEmpty())
        {
            pair p=q.remove();
            String s=p.s;
            int dis=p.dis;
            if(s.equals(endWord))
            {
                return dis;
            }
            char carray[]=s.toCharArray();
            for(int i=0;i<carray.length;i++)
            {
                char orig=carray[i];
                for(char c='a';c<='z';c++)
                {
                    if(c==orig)
                    {
                        continue;
                    }
                    carray[i]=c;
                    String word=new String(carray);
                    if(set.contains(word))
                    {
                        set.remove(word);
                        q.add(new pair(word,dis+1));
                    }
                }
                carray[i]=orig;
            }
        }
        return 0;
    }
}