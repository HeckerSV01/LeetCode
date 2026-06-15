class Solution {
    private boolean backtrack(int n,int num,List<Integer> list,HashSet<Integer> vis){
        if(list.size()==num){
            if(Integer.bitCount(list.get(list.size()-1)^0)==1){
                return true;
            }
            return false;
        }
        int k=list.get(list.size()-1);
        for(int i=0;i<n;i++){
            int newnum=k^(1<<i);
            if(!vis.contains(newnum)){
                vis.add(newnum);
                list.add(newnum);
                if(backtrack(n,num,list,vis)){
                    return true;
                }
                vis.remove(newnum);
                list.remove(list.size()-1);
            }
        }
        return false;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> list=new ArrayList<>();
        HashSet<Integer> vis=new HashSet<>();
        int num=1<<n;
        list.add(0);
        vis.add(0);
        backtrack(n,num,list,vis);
        return list;
    }
}