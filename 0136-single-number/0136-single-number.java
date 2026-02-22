class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int k:nums){
            map.put(k,map.getOrDefault(k,0)+1);
        }
        for(int k:map.keySet()){
            if(map.get(k)==1){
                return k;
            }
        }
        return -1;
    }
}