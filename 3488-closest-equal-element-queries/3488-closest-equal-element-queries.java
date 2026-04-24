class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            List<Integer> l=map.get(nums[queries[i]]);
            if(l.size()==1){
                res.add(-1);
                continue;
            }
            int idx=Collections.binarySearch(l,queries[i]);
            int a1=-1;
            int a2=-1;
            if(idx==0){
                a1=l.size()-1;
                a2=1;
            }
            else if(idx==l.size()-1){
                a1=0;
                a2=idx-1;
            }else{
            a1=idx+1;
            a2=idx-1;
            }
            int dis1=Math.min(Math.abs(l.get(idx)-l.get(a1)),nums.length-Math.abs(l.get(idx)-l.get(a1)));
            int dis2=Math.min(Math.abs(l.get(idx)-l.get(a2)),nums.length-Math.abs(l.get(idx)-l.get(a2)));
            res.add(Math.min(dis1,dis2));
        }
        return res;
    }
}