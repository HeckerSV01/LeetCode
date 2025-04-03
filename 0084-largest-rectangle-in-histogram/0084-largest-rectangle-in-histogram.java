class Solution {
    public int[] rightsmall(int arr[])
    {
        Stack<Integer> s=new Stack<>();
        int ret[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                ret[i]=arr.length;
            } 
            else{
                ret[i]=s.peek();
            }
            s.push(i);
        }
        return ret;
    }
    public int[] leftsmall(int arr[])
    {
        Stack<Integer> s=new Stack<>();
        int ret[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                ret[i]=-1;
            } 
            else{
                ret[i]=s.peek();
            }
            s.push(i);
        }
        return ret;
    }
    public int largestRectangleArea(int[] heights) {
        int maxarea=Integer.MIN_VALUE;
        int right[]=rightsmall(heights);
        int left[]=leftsmall(heights);
        for(int i=0;i<heights.length;i++)
        {
           int area=(right[i]-left[i]-1)*heights[i];
           maxarea=Math.max(maxarea,area);
        }
        return maxarea;
    }
}