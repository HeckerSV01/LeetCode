class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid=nums[nums.length/2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return map.get(mid)==1;
    }
}