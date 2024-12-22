class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int maxwater = Integer.MIN_VALUE;
        while(p1<=p2)
        {
          maxwater = Math.max(maxwater, Math.min(height[p1], height[p2]) * (p2 - p1));
          if(height[p1]>height[p2])
          {
            p2--;
          }
          else
          p1++;
        } 
        return maxwater;        
    }
}