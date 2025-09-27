class Solution {
    public void back(List<List<Integer>> res,List<Integer> list,int i,int target,int a[],int sum)
    {
        if(i==a.length&&sum==target)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        if(i==a.length)
        {
            return;
        }
        if(sum+a[i]<=target)
        {
            list.add(a[i]);
            back(res,list,i,target,a,sum+a[i]); 
            list.remove(list.size()-1);  
        }
        back(res,list,i+1,target,a,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        back(res,list,0,target,candidates,0);
        return res;
    }
}