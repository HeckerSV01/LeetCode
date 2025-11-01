class Cashier {
int n;
int discount;
HashMap<Integer,Integer> map;
int counter;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n=n;
        this.discount=discount;
        map=new HashMap<>();
        counter=0;
        for(int i=0;i<products.length;i++)
        {
            map.put(products[i],prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        ++counter;
        int total=0;
        for(int i=0;i<product.length;i++)
        {
            total=total+map.get(product[i])*amount[i];
        }
        if(counter%n==0)
        {
            return (double)total*(1-discount/100.0);
        }
        else
        {
            return (double)total;
        }
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */