class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int k:arr)
        {
            map.put(k,map.getOrDefault(k,0)+1);
        }
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list,Collections.reverseOrder());
        int res=0;
        int sum=0;
        int n=arr.length;
        for(int i=0;i<list.size();i++)
        {
            sum=sum+list.get(i);
            res++;
            if(sum>=n/2)
            {
                break;
            }
        }
        return res;
    }
}