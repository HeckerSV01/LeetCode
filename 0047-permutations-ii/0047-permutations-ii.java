class Solution {
    public void backtrack(int a[],List<Integer> list,HashMap<Integer,Integer> map,HashSet<ArrayList<Integer>> set){
        if(list.size()==a.length){
            set.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<a.length;i++){
            if(map.get(a[i])>0){
                map.put(a[i],map.get(a[i])-1);
                list.add(a[i]);
                backtrack(a,list,map,set);
                list.remove(list.size()-1);
                map.put(a[i],map.get(a[i])+1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        backtrack(nums,list,map,set);
        for(List<Integer> k:set){
            res.add(k);
        }
        return res;
    }
}