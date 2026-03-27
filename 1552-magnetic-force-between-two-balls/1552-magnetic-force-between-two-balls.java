class Solution {
    private boolean canweplace(int a[],int m,int mindis){
        int count=1;
        int lastpos=0;
        for(int i=1;i<a.length;i++){
            if(a[i]-a[lastpos]>=mindis){
                lastpos=i;
                count++;
            }
        }
        if(count>=m){
            return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int f=1;
        int l=1000000000;
        int res=Integer.MIN_VALUE;
        while(f<=l){
            int mid=f+(l-f)/2;
            boolean temp=canweplace(position,m,mid);
            if(temp){
                f=mid+1;
                res=Math.max(res,mid);
            }else{
                l=mid-1;
            }
        }
        return res;
    }
}