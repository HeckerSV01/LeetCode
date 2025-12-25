class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        boolean check=true;
        for(int i=0;i<nums.length;i=i+3)
        {
            if(nums[i+2]-nums[i]>k)
            {
                check=false;
                break;
            }
        }
        int res[][]=new int[nums.length/3][3];
        int l=0;
        if(check)
        {
            for(int i=0;i<nums.length/3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    res[i][j]=nums[l];
                    l++;
                }
            }
            return res;
        }
        else
        {
            return new int[][]{};
        }
    }
}