class ThroneInheritance {
HashMap<String,List<String>> map;
HashSet<String> dead;
String root="";
    public ThroneInheritance(String kingName) {
        map=new HashMap<>();
        dead=new HashSet<>();
        root=kingName;
    }
    
    public void birth(String parentName, String childName) {
        if(!map.containsKey(parentName))
        {
            map.put(parentName,new ArrayList<>());
        }
        map.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public void recur(String root,List<String> res)
    {
        if(!dead.contains(root))
        {
            res.add(root);
        }
        if (!map.containsKey(root))
        { 
            return;
        }
        for(String s:map.get(root))
        {
            recur(s,res);
        }
    }
    public List<String> getInheritanceOrder() {
        List<String> res=new ArrayList<>();
        recur(root,res);
        return res;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */