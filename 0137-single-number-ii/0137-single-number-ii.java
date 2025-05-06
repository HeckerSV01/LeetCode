class Solution {
    public int singleNumber(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
       ArrayList<Integer> l=new ArrayList<>();
       for(int i=0;i<nums.length;i++)
       {
          if(map.containsKey(nums[i]))
          {
            l.remove(Integer.valueOf(nums[i]));
          }
          else
          {
            map.put(nums[i],1);
            l.add(nums[i]);
          }
       } 
       return l.get(0);
    }
}