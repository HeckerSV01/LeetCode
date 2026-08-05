class Solution {
    private void dfs(List<List<Integer>> adj,int node,HashSet<Integer> isSus){
        isSus.add(node);
        for(int k:adj.get(node)){
            if(!isSus.contains(k)){
                dfs(adj,k,isSus);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> revadj=new ArrayList<>();
        int indeg[]=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            revadj.add(new ArrayList<>());
        }
        for(int i[]:invocations){
            adj.get(i[0]).add(i[1]);
            revadj.get(i[1]).add(i[0]);
            indeg[i[1]]++;
        }
        HashSet<Integer> isSus=new HashSet<>();
        dfs(adj,k,isSus);
        boolean check=true;
        for(int i:isSus){
            for(int m:revadj.get(i)){
                if(!isSus.contains(m)){
                    check=false;
                    break;
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        if(check){
            for(int i=0;i<n;i++){
                if(!isSus.contains(i)){
                    res.add(i);
                }
            }
        }else{
            for(int i=0;i<n;i++){
                res.add(i);
            }
        }
        return res;
    }
}