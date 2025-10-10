class pair{
    String s;
    int time;
    public pair(String s,int time)
    {
        this.s=s;
        this.time=time;
    }
}
class TimeMap {
HashMap<String,ArrayList<pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        {
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res="";
        if(!map.containsKey(key))
        {
            return res;
        }
        ArrayList<pair> list=map.get(key);
        int st=0;
        int en=list.size()-1;
        while(st<=en)
        {
            int mid=(st+en)/2;
            if(list.get(mid).time==timestamp)
            {
                res=list.get(mid).s;
                break;
            }
            else if(list.get(mid).time>timestamp)
            {
                en=mid-1;
            }
            else
            {
                res=list.get(mid).s;
                st=mid+1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */