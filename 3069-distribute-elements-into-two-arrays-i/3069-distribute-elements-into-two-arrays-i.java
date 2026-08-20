class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int i=0;
        l1.add(nums[i]);
        i++;
        l2.add(nums[i]);
        i++;
        while(i<nums.length){
            if(l1.get(l1.size()-1)>l2.get(l2.size()-1)){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
            i++;
        }
        i=0;
        int res[]=new int[nums.length];
        for(int k:l1){
            res[i]=k;
            i++;
        }
        for(int k:l2){
            res[i]=k;
            i++;
        }
        return res;
    }
}