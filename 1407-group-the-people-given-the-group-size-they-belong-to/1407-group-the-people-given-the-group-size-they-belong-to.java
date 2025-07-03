class Solution {
    public List<List<Integer>> groupThePeople(int[] group) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<group.length;i++)
        {
            if(!map.containsKey(group[i]))
            {
                map.put(group[i],new ArrayList<>());
            }
            map.get(group[i]).add(i);
            if(map.get(group[i]).size()==group[i])
            {
                list.add(new ArrayList<>(map.get(group[i])));
                map.get(group[i]).clear();
            }
        }
        return list;
    }
}