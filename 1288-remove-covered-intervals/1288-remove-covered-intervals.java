class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            list.get(i).add(intervals[i][0]);
            list.get(i).add(intervals[i][1]);
        }
        Collections.sort(list,(a,b)->{
            if(a.get(0)==b.get(0)){
                return b.get(1)-a.get(1);
            }
            return a.get(0)-b.get(0);
        });
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if((list.get(i).get(0)<=list.get(j).get(0)&&list.get(j).get(1)<=list.get(i).get(1))){
                    list.remove(j);
                    j--;
                }
            }
        }
        return list.size();
    }
}