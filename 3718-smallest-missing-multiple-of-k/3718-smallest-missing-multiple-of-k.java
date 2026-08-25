class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        for(int i=1;i>=0;i++){
            if(!set.contains(k*i)){
                return k*i;
            }
        }
        return -1;
    }
}