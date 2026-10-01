class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=1;i<=m;i++){
            list.add(i);
        }
        int res[]=new int[queries.length];
        int i=0;
        for(int k:queries){
            int idx=list.indexOf(k);
            res[i++]=idx;
            list.remove(Integer.valueOf(k));
            list.addFirst(k);
        }
        return res;
    }
}