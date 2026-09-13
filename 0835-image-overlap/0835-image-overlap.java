class idx{
    int i;
    int j;
    public idx(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<idx> l1=new ArrayList<>();
        List<idx> l2=new ArrayList<>();
        for(int i=0;i<img1.length;i++){
            for(int j=0;j<img1[0].length;j++){
                if(img1[i][j]==1){
                    l1.add(new idx(i,j));
                }
            }
        }
        for(int i=0;i<img2.length;i++){
            for(int j=0;j<img2[0].length;j++){
                if(img2[i][j]==1){
                    l2.add(new idx(i,j));
                }
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<l1.size();i++){
            for(int j=0;j<l2.size();j++){
                int rowdiff=l2.get(j).i-l1.get(i).i;
                int coldiff=l2.get(j).j-l1.get(i).j;
                map.put(rowdiff*100+coldiff,map.getOrDefault(rowdiff*100+coldiff,0)+1);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int k:map.keySet()){
            max=Math.max(max,map.get(k));
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}