class Solution {
    private void backtrack(int a[],int i,int prev,HashSet<List<Integer>> res,List<Integer> list){
        if(list.size()>=2){
            res.add(new ArrayList<>(list));
        }
        if(i==a.length){
            return;
        }
        for(int j=i;j<a.length;j++){
            if(prev==-1||a[j]>=a[prev]){
                list.add(a[j]);
                backtrack(a,j+1,j,res,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashSet<List<Integer>> res=new HashSet<>();
        backtrack(nums,0,-1,res,list);
        List<List<Integer>> l=new ArrayList<>();
        for(List<Integer> k:res){
            l.add(k);
        } 
        return l;
    }
}