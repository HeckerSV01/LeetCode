class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int idx=discounts.length-1;
        double res=0.0D;
        int k=prices.length-1;
        while(idx>=0&&k>=0){
            res=res+(double)(prices[k]*(100-discounts[idx]))/100;
            idx--;
            k--;
        }
        while(k>=0){
            res=res+prices[k];
            k--;
        }
        return res;
    }
}