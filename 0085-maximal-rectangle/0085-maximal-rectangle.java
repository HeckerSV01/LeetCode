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
    public int largestarea(int[] heights) {
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
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int a[][]=new int[m][n];
        for(int i=0;i<n;i++){
            a[0][i]=matrix[0][i]-'0';
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[j][i]=='0'){
                    continue;
                }else{
                    a[j][i]=a[j-1][i]+matrix[j][i]-'0';
                }
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            res=Math.max(res,largestarea(a[i]));
        }
        return res;
    }
}