class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int r=0;
        int l=0;
        int res=-1;
        int n=fruits.length;
        while(r<n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                int k=fruits[l];
                if(map.get(k)>1){
                    map.put(k,map.get(k)-1);
                }else{
                    map.remove(k);
                }
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}