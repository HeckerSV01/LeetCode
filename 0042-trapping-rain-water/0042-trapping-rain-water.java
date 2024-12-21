class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int maxleft[]=new int[len];
        maxleft[0]=height[0];
        for(int i=1;i<len;i++)
        {
            maxleft[i]=Math.max(height[i],maxleft[i-1]);
        }
        int rightmax[]=new int[len];
        rightmax[len-1]=height[len-1];
        for(int i=len-2;i>=0;i--)
        {
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }
        int water;
        int vol=0;
        for(int i=0;i<len;i++)
        {
            water=Math.min(maxleft[i],rightmax[i]);
            vol+=(water-height[i])*1;
        }
        return vol;
    }
}