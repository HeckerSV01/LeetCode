class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        while(!map.isEmpty()){
            int t=map.firstKey();
            for(int j=0;j<k;j++){
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