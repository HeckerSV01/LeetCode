class pair{
    String st;
    int time;
    public pair(String st,int time)
    {
        this.st=st;
        this.time=time;
    }
}
class UndergroundSystem {
HashMap<Integer,pair> map1;
HashMap<String,List<Integer>> map2;
    public UndergroundSystem() {
        map1=new HashMap<>();
        map2=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        map1.put(id,new pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String st=map1.get(id).st;
        String key=st+"-"+stationName;
        int time=t-map1.get(id).time;
        if(!map2.containsKey(key))
        {
            map2.put(key,new ArrayList<>());
        }
        map2.get(key).add(time);
        map1.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int sum=0;
        String key=startStation+"-"+endStation;
        for(int k:map2.get(key))
        {
            sum=sum+k;
        }
        return (double)sum/map2.get(key).size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */