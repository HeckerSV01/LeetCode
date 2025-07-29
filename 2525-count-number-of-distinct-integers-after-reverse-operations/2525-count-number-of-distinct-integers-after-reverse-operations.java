class Solution {
    public int check(int num)
    {
        int k=num;
        int rev=0;
        while(k>0)
        {
            int l=k%10;
            rev=10*rev+l;
            k=k/10;
        }
        return rev;
    }
    public int countDistinctIntegers(int[] nums) {
       HashSet<Integer> set=new HashSet<>();
       for(int i:nums)
       {
        set.add(i);
        set.add(check(i));
       }
       return set.size();
    }
}