class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int k:nums)
        {
            l.add(k);
        }
        for(int i=l.size()-1;i>=1;i--)
        {
            if(l.get(i).equals(l.get(i-1)))
            {
                l.remove(i);
            }
        }
        int count=0;
        for(int i=1;i<l.size()-1;i++)
        {
            if(l.get(i)>l.get(i-1)&&l.get(i)>l.get(i+1)||l.get(i)<l.get(i-1)&&l.get(i)<l.get(i+1))
            {
                count++;
            }
        }
        return count;
    }
}