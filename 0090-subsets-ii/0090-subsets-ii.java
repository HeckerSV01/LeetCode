class Solution {
    public void back(List<List<Integer>> res,List<Integer> list,int idx,int a[])
    {
        res.add(new ArrayList<>(list));
        for(int i=idx;i<a.length;i++)
        {
            if(i>idx&&a[i]==a[i-1])
            {
                continue;
            }
            list.add(a[i]);
            back(res,list,i+1,a);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        back(res,list,0,nums);
        return res; 
    }
}