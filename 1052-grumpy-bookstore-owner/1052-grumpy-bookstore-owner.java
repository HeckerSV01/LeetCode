class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                res=res+customers[i];
            }
        }
        int l=0;
        int r=minutes-1;
        int extra=0;
        for(int i=l;i<=r;i++){
            if(grumpy[i]==1){
                extra=extra+customers[i];
            }
        }
        int max=extra;
        while(r<customers.length-1){
            if(grumpy[l]==1){
                extra=extra-customers[l];
            }
            l++;
            r++;
            if(grumpy[r]==1){
                extra=extra+customers[r];
            }
            max=Math.max(max,extra);
        }
        return res+max;
    }
}