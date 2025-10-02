class Solution { 
     public void back(List<List<Integer>> res,List<Integer> list,int idx,int target,int a[])
    {
        if(target==0)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<a.length;i++)
        {
            if(i>idx&&a[i]==a[i-1])
            {
                continue;
            }
            if(a[i]>target)
            {
                break;
            }
            list.add(a[i]);
            back(res,list,i+1,target-a[i],a);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list=new ArrayList<>();
        back(res,list,0,target,candidates);
        return res;
    }
}