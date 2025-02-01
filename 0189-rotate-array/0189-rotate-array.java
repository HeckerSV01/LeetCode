class Solution {
    public void rotate(int[] nums, int k) {
        if(k>=nums.length)
        {
            k=k%nums.length;
        }
        int alast[] = new int[k];
        int afirst[] = new int[nums.length - k];
        for (int i = 0; i < k ; i++) {
            alast[i] = nums[nums.length-k+i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            afirst[i] = nums[i];
        }
        for(int i=0;i<k;i++)
        {
          nums[i]=alast[i];
        }
        for(int i=0;i<nums.length-k;i++)
        {
            nums[i+k]=afirst[i];
        }
    }
}