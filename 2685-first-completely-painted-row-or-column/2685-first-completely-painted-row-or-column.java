class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int freqi[]=new int[m];
        int freqj[]=new int[n];
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            int k[]=map.get(arr[i]);
            freqi[k[0]]++;
            freqj[k[1]]++;
            if(freqi[k[0]]==n||freqj[k[1]]==m)
            {
                return i;
            }
        }
        return -1;
    }
}