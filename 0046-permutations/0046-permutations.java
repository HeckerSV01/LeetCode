class Solution {
    public void backtrack(int a[],List<List<Integer>> res,List<Integer> list,int mark[])
    {
        if(list.size()==a.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<a.length;i++)
        {
            if(mark[i]==0)
            {
                mark[i]=1;
                list.add(a[i]);
                backtrack(a,res,list,mark);
                list.remove(list.size()-1);
                mark[i]=0;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int mark[]=new int[nums.length];
        backtrack(nums,res,list,mark);
        return res;
    }
}