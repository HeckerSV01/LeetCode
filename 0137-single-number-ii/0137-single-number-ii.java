class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> ones=new HashSet<>();
        HashSet<Integer> twos=new HashSet<>();
        HashSet<Integer> threes=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!ones.contains(nums[i])){
                ones.add(nums[i]);
            }else if(ones.contains(nums[i])&&!threes.contains(nums[i])){
                twos.add(nums[i]);
            }else if(ones.contains(nums[i])&&twos.contains(nums[i])){
                threes.add(nums[i]);
            }
        }
        int res=-1;
        for(int k:ones){
            if(!twos.contains(k)){
                res=k;
                break;
            }
        }
        return res;
    }
}