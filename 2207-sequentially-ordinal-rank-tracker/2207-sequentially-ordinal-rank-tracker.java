class pair{
    String place;
    int score;
    public pair(String place,int score)
    {
        this.place=place;
        this.score=score;
    }
}
class SORTracker {
PriorityQueue<pair> high;
PriorityQueue<pair> low;
    public SORTracker() {
        high=new PriorityQueue<>((a,b)->{
            if(a.score==b.score)
            {
                return a.place.compareTo(b.place);
            }
            else
            {
                return b.score-a.score;
            }
        });
        low=new PriorityQueue<>((a,b)->{
            if(a.score==b.score)
            {
                return b.place.compareTo(a.place);
            }
            else
            {
                return a.score-b.score;
            }
        });
    }
    public int compare(pair a,pair b) 
    {
        if(a.score==b.score)
        {   
            return a.place.compareTo(b.place);
        }
        return b.score - a.score;
    }
    public void add(String name, int score) {
        high.add(new pair(name,score));
        if (!low.isEmpty()&&compare(high.peek(),low.peek())<0) 
        {
            low.add(high.remove());
            high.add(low.remove());
        }
    }
    
    public String get() {
        low.add(high.remove());
        return low.peek().place;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */