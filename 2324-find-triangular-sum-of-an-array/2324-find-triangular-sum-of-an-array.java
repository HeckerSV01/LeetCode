class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int k:nums)
        {
            l.add(k);
        }
        while(l.size()>1)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<l.size()-1;i++)
            {
                temp.add((l.get(i)+l.get(i+1))%10);
            }
            l=temp;
        }
        return l.get(0);
    }
}