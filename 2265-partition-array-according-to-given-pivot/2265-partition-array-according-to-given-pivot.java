class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();
        ArrayList<Integer> l3=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                l1.add(nums[i]);
            }
            else if(nums[i]>pivot)
            {
                l2.add(nums[i]);
            }
            else
            {
                l3.add(nums[i]);
            }
        }
        l3.addAll(l2);
        l1.addAll(l3);
        int res[]=new int[l1.size()];
        for(int i=0;i<l1.size();i++)
        {
            res[i]=l1.get(i);
        }
        return res;
    }
}