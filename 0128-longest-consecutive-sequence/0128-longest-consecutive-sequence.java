class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxlen=0;
        for(int n:set){
            if(!set.contains(n-1)){
                int k=1;
                while(set.contains(n+k)){
                    k++;
                }
                maxlen=Math.max(maxlen,k);
            }
        }
        return maxlen;
    }
}