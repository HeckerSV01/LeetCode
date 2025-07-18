class Trie {
HashMap<String,Integer> map;
    public Trie() {
        map=new HashMap<>();
    }
    
    public void insert(String word) {
        map.put(word,map.getOrDefault(word,0)+1);
    }
    
    public boolean search(String word) {
        return map.containsKey(word);
    }
    
    public boolean startsWith(String prefix) {
        for(String st:map.keySet())
        {
            if(st.startsWith(prefix))
            {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */