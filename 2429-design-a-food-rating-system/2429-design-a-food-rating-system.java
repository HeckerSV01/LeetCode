class pair{
    String a;
    int r;
    public pair(String a,int r)
    {
        this.a=a;
        this.r=r;
    }
}
class FoodRatings {
HashMap<String,pair> map1;
HashMap<String,PriorityQueue<pair>> map2; 
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map1=new HashMap<>();
        map2=new HashMap<>();
        for(int i=0;i<foods.length;i++)
        {
            map1.put(foods[i],new pair(cuisines[i],ratings[i]));
            if(!map2.containsKey(cuisines[i]))
            {
                map2.put(cuisines[i],new PriorityQueue<>((a,b)->{
                if(a.r!=b.r)
                {
                    return b.r-a.r;
                }
                else
                {
                    return a.a.compareTo(b.a);
                }
                }));
            }
            map2.get(cuisines[i]).add(new pair(foods[i],ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cui=map1.get(food).a;
        map1.put(food,new pair(cui,newRating));
        map2.get(cui).add(new pair(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        pair p=map2.get(cuisine).peek();
        while(map1.get(p.a).r!=p.r)
        {
            map2.get(cuisine).remove();
            p=map2.get(cuisine).peek();
        }
        return map2.get(cuisine).peek().a;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */