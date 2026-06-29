class Solution {
    public int minimumCardPickup(int[] cards) {
        int l=0;
        int r=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxfreq=0;
        int maxnum=-1;
        int res=Integer.MAX_VALUE;
        while(r<cards.length){
            map.put(cards[r],map.getOrDefault(cards[r],0)+1);
            if(map.get(cards[r])>maxfreq){
                maxfreq=map.get(cards[r]);
                maxnum=cards[r];
            }
            while(maxfreq==2){
                res=Math.min(res,r-l+1);
                map.put(cards[l],map.get(cards[l])-1);
                if(maxnum==cards[l]){
                    maxfreq--;
                }
                l++;
            }
            r++;
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}