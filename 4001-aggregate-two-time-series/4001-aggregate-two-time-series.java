class Solution {
    private int upperbound(int arr[],int k){
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > k) {
                ans = arr[mid];
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        TreeSet<Integer> set=new TreeSet<>();
        TreeMap<Integer,Integer> map1=new TreeMap<>();
        TreeMap<Integer,Integer> map2=new TreeMap<>();
        HashMap<Integer,Integer> nextof1in2=new HashMap<>();
        HashMap<Integer,Integer> nextof2in1=new HashMap<>();
        int maxtime1=-1;
        int maxtime2=-1;
        for(int i=0;i<series1.length;i++){
            set.add(series1[i][0]);
            map1.put(series1[i][0],series1[i][1]);
            maxtime1=Math.max(maxtime1,series1[i][0]);
        }
        for(int i=0;i<series2.length;i++){
            set.add(series2[i][0]);
            map2.put(series2[i][0],series2[i][1]);
            maxtime2=Math.max(maxtime2,series2[i][0]);
        }
        for(int k:set){
            if(!map1.containsKey(k)){
                nextof2in1.put(k,map1.higherKey(k));
            }
            if(!map2.containsKey(k)){
                nextof1in2.put(k,map2.higherKey(k));
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i:set){
            int sum=0;
            if(map1.containsKey(i)){
                sum=sum+map1.get(i);
            }else{
                if(nextof2in1.get(i)!=null){
                    sum=sum+map1.get(nextof2in1.get(i));
                }else{
                    sum=sum+0;
                }
            }
            if(map2.containsKey(i)){
                sum=sum+map2.get(i);
            }else{
                if(nextof1in2.get(i)!=null){
                    sum=sum+map2.get(nextof1in2.get(i));
                }else{
                    sum=sum+0;
                }
            }
            List<Integer> l=new ArrayList<>();
            l.add(i);
            l.add(sum);
            res.add(l);
        }
        return res;
    }
}