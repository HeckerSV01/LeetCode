class Solution {
    public void back(List<Integer> list,List<List<Integer>> res,int i,int a[],int n,int k)
    {
        if(list.size()==k)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        else if(i==n)
        {
            return;
        }
        list.add(a[i]);
        back(list,res,i+1,a,n,k);
        list.remove(list.size()-1);
        back(list,res,i+1,a,n,k);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=i+1;
        }
        back(list,res,0,a,n,k);
        return res;
    }
}