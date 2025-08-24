class MagicDictionary {
String a[];
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        a=dictionary;
    }
    
    public boolean search(String searchWord) {
        for(int i=0;i<a.length;i++)
        {
            if(a[i].length()!=searchWord.length())
            {
                continue;
            }
            int count=0;
            for(int j=0;j<searchWord.length();j++)
            {
                if(a[i].charAt(j)!=searchWord.charAt(j))
                {
                    count++;
                    if(count>1)
                    {
                        break;
                    }
                }
            }
            if(count==1)
            {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */