class pair{
    int shop;
    int movie;
    int price;
    public pair(int shop,int movie,int price)
    {
        this.movie=movie;
        this.shop=shop;
        this.price=price;
    }
}
class MovieRentingSystem {
HashMap<Integer,TreeSet<pair>> map;
TreeSet<pair> rented;
HashMap<Integer,HashMap<Integer,pair>> lookup;
Comparator<pair> cmp;
    public MovieRentingSystem(int n, int[][] entries) {
        cmp=(a,b)->{
            if(a.price!=b.price) return a.price-b.price;
            if(a.shop!=b.shop) return a.shop-b.shop;
            return a.movie-b.movie;
        };
        map=new HashMap<>();
        rented=new TreeSet<>(cmp);
        lookup=new HashMap<>();
        for(int i=0;i<entries.length;i++)
        {
            int shop=entries[i][0];
            int movie=entries[i][1];
            int price=entries[i][2];
            pair p=new pair(shop,movie,price);
            map.computeIfAbsent(movie,k->new TreeSet<>(cmp)).add(p);
            lookup.computeIfAbsent(movie,k->new HashMap<>()).put(shop,p);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> l=new ArrayList<>();
        if(!map.containsKey(movie))
        {
            return l;
        }
        int cnt=0;
        for(pair p:map.get(movie))
        {
            l.add(p.shop);
            cnt++;
            if(cnt==5) break;
        }
        return l;
    }
    
    public void rent(int shop, int movie) {
        if(!lookup.containsKey(movie)) return;
        pair p=lookup.get(movie).get(shop);
        if(p!=null)
        {
            map.get(movie).remove(p);
            rented.add(p);
        }
    }
    
    public void drop(int shop, int movie) {
        if(!lookup.containsKey(movie)) return;
        pair p=lookup.get(movie).get(shop);
        if(p!=null)
        {
            rented.remove(p);
            map.computeIfAbsent(movie,k->new TreeSet<>(cmp)).add(p);
        }
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res=new ArrayList<>();
        int cnt=0;
        for(pair p:rented)
        {
            List<Integer> entry=new ArrayList<>();
            entry.add(p.shop);
            entry.add(p.movie);
            res.add(entry);
            cnt++;
            if(cnt==5) break;
        }
        return res;
    }
}
/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */