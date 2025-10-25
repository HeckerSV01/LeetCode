class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums[0].length();
        HashSet<String> set=new HashSet<>();
        for(String k:nums)
        {
            set.add(k);
        }
        String st="";
        for(int i=0;i<(int)Math.pow(2,n);i++)
        {
            st=String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            if(!set.contains(st))
            {
                break;
            }
        }
        return st;
    }
}