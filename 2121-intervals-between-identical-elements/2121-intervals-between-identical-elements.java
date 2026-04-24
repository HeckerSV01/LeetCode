class Solution {
    public long[] getDistances(int[] arr) {
        long res[]=new long[arr.length];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for(int k:map.keySet()){
            List<Integer> l=map.get(k);
            long pref[]=new long[l.size()];
            pref[0]=l.get(0);
            for(int i=1;i<l.size();i++){
                pref[i]=pref[i-1]+l.get(i);
            }
            for(int i=0;i<l.size();i++){
                long prev=0;
                long next=0;
                if(i>0){
                    prev=1L*i*l.get(i)-pref[i-1];
                }
                if(i<l.size()-1){
                    next=(pref[l.size()-1]-pref[i])-(1L*(l.size()-1-i)*l.get(i));
                }
                res[l.get(i)]=prev+next;
            }
        }
        return res;
    }
}