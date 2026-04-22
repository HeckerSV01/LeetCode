class Solution {
    private int rev(int n){
        int k=n;
        int res=0;
        while(k>0){
            int t=k%10;
            res=res*10+t;
            k=k/10;
        }
        return res;
    }
    public int minMirrorPairDistance(int[] nums) {
        int res=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int revd=rev(nums[i]);
            if(map.containsKey(nums[i])){
                res=Math.min(res,Math.abs(i-map.get(nums[i])));
            }
            map.put(revd,i);
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}