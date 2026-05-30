class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        int l=0;
        int r=0;
        for(int k:nums){
            map1.put(k,map1.getOrDefault(k,0)+1);
        }
        while(r<nums.length){
            map2.put(nums[r],map2.getOrDefault(nums[r],0)+1);
            while(map1.size()==map2.size()){
                count=count+nums.length-r;
                if(map2.get(nums[l])>1){
                    map2.put(nums[l],map2.get(nums[l])-1);
                }else{
                    map2.remove(nums[l]);
                }
                l++;
            }
            r++;
        }
        return count;
    }
}