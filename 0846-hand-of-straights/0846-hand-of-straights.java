class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while(!map.isEmpty()){
            int t=map.firstKey();
            for(int j=0;j<groupSize;j++){
                int curr=t+j;
                if(!map.containsKey(curr)){
                    return false;
                }
                if(map.get(curr)==1){
                    map.remove(curr);
                }else{
                    map.put(curr,map.get(curr)-1);
                }
            } 
        }
        return true;
    }
}