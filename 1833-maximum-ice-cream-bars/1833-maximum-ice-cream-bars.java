class Solution {
    public int maxIceCream(int[] costs, int coins) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=-1;
        for(int i=0;i<costs.length;i++){
            map.put(costs[i],map.getOrDefault(costs[i],0)+1);
            max=Math.max(max,costs[i]);
        }
        int res=0;
        for(int i=1;i<=max&&coins>0;i++){
            if(!map.containsKey(i)){
                continue;
            }
            if(map.containsKey(i)&&map.get(i)==0){
                continue;
            }
            int k=Math.min(map.get(i),coins/i);
            res=res+k;
            coins=coins-k*i;
        }
        return res;
    }
}