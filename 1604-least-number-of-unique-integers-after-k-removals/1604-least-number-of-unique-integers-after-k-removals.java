class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i:map.values())
        {
            list.add(i);
        }
        Collections.sort(list);
        int i=0;
        while(k>0)
        {
            int temp=list.get(i);
            k=k-temp;
            if(k<0)
            {
                break;
            }
            i++;
        }
        return list.size()-i;
    }
}