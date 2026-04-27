class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res=0;
        for(int i=piles.length-2;i>=piles.length/3;i=i-2){
            res=res+piles[i];
        }
        return res;
    }
}