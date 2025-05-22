class Solution {
    public int[] productExceptSelf(int[] nums) {
        ArrayList<Integer> lp=new ArrayList<>();
        ArrayList<Integer> rp=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            lp.add(0);
            rp.add(0);
        }
        lp.set(0,1);
        rp.set(nums.length-1,1);
        for(int i=1;i<nums.length;i++)
        {
            lp.set(i,lp.get(i-1)*nums[i-1]);
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            rp.set(i,rp.get(i+1)*nums[i+1]);
        }
        int res[]=new int[lp.size()];
        for(int i=0;i<lp.size();i++)
        {
            lp.set(i,lp.get(i)*rp.get(i));
            res[i]=lp.get(i);
        }
        return res;
    }
}