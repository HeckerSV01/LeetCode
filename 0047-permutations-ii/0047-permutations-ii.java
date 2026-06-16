class Solution {
    public void backtrack(int a[],List<Integer> list,HashMap<Integer,Integer> map,List<List<Integer>> res){
        if(list.size()==a.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int k:map.keySet()){
            if(map.get(k)>0){
                map.put(k,map.get(k)-1);
                list.add(k);
                backtrack(a,list,map,res);
                list.remove(list.size()-1);
                map.put(k,map.get(k)+1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        backtrack(nums,list,map,res);
        return res;
    }
}