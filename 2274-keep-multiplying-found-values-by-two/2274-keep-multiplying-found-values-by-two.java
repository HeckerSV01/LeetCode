class Solution {
    public boolean found(int a[],int k)
    {
        for(int i:a)
        {
            if(i==k)
            {
                return true;
            }
        }
        return false;
    }
    public int findFinalValue(int[] nums, int original) {
        while(found(nums,original))
        {
            original=original*2;
        }
        return original;
    }
}