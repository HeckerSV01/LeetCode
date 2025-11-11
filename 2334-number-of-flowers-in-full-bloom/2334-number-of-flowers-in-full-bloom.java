class Solution {
    public int bs(int a[],int key)
    {
        int st=0;
        int en=a.length-1;
        int idx=-1;
        while(st<=en)
        {
            int mid=(st+en)/2;
            if(a[mid]<=key)
            {
                idx=mid;
                st=mid+1;
            }
            else
            {
                en=mid-1;
            }
        }
        return idx;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int res[]=new int[people.length];
        int start[]=new int[flowers.length];
        int en[]=new int[flowers.length];
        for(int i=0;i<flowers.length;i++)
        {
            start[i]=flowers[i][0];
            en[i]=flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(en);
        for(int i=0;i<people.length;i++)
        {
            int a=bs(start,people[i]);
            int b=bs(en,people[i]-1);
            res[i]=a-b;
        }
        return res;
    }
}