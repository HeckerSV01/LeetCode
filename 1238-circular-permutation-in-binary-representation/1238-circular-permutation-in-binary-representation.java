class Solution {
    private boolean backtrack(int n,int num,List<Integer> list,HashSet<Integer> vis){
        if(list.size()==num){
            if(Integer.bitCount(list.get(list.size()-1)^list.get(0))==1){
                return true;
            }
            return false;
        }
        int k=list.get(list.size()-1);
        for(int i=0;i<num;i++){
            int newnum=k^(1<<i);
            if(!vis.contains(newnum)){
                list.add(newnum);
                vis.add(newnum);
                if(backtrack(n,num,list,vis)){
                    return true;
                }
                list.remove(list.size()-1);
                vis.remove(newnum);
            }
        }
        return false;
    }
    public List<Integer> circularPermutation(int n, int start) {
        int num=1<<n;
        List<Integer> list=new ArrayList<>();
        HashSet<Integer> vis=new HashSet<>();
        list.add(start);
        vis.add(start);
        backtrack(n,num,list,vis);
        return list;
    }
}