class Solution {
    public int maxidx(int a[])
    {
        int max=a[0];
        int res=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>max)
            {
                res=i;
                max=a[i];
            }
        }
        return res;
    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diag[]=new int[dimensions.length];
        for(int i=0;i<dimensions.length;i++)
        {
            diag[i]=dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1];
        }
        int max=maxidx(diag);
        int maxd=diag[max];
        List<Integer> similardiag=new ArrayList<>();
        for(int i=0;i<diag.length;i++)
        {
            if(diag[i]==maxd)
            {
                similardiag.add(i);
            }
        }
        int res=-1;
        for(int i=0;i<similardiag.size();i++)
        {
            if(dimensions[similardiag.get(i)][0]*dimensions[similardiag.get(i)][1]>res)
            {
                res=dimensions[similardiag.get(i)][0]*dimensions[similardiag.get(i)][1];
            }
        }
        return res;
    }
}