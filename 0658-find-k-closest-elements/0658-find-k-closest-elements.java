class pair{
    int val;
    int diff;
    public pair(int val,int diff){
        this.val=val;
        this.diff=diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.diff==b.diff){
                return b.val-a.val;
            }else{
                return b.diff-a.diff;
            }
        });
        pair a[]=new pair[arr.length];
        for(int i=0;i<arr.length;i++){
            a[i]=new pair(arr[i],Math.abs(arr[i]-x));
        }
        for(int i=0;i<arr.length;i++){
            pq.offer(a[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().val);
        }
        Collections.sort(res);
        return res;
    }
}