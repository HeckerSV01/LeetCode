class Solution {
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer,PriorityQueue<Integer>> map=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            String st=Integer.toBinaryString(arr[i]);
            int ones=0;
            for(int j=0;j<st.length();j++){
                if(st.charAt(j)=='1'){
                    ones++;
                }
            }
            if(!map.containsKey(ones)){
                map.put(ones,new PriorityQueue<>());
            }
            map.get(ones).add(arr[i]);
        }
        int res[]=new int[arr.length];
        int i=0;
        for(int k:map.keySet()){
            PriorityQueue<Integer> pq=map.get(k);
            while(!pq.isEmpty()){
                res[i]=pq.poll();
                i++;
            }
        }
        return res;
    }
}