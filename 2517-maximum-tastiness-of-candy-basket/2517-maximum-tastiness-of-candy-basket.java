class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int mindiff=Integer.MAX_VALUE;
        int maxdiff=price[price.length-1]-price[0];
        for(int i=1;i<price.length;i++){
            mindiff=Math.min(mindiff,price[i]-price[i-1]);
        }
        int res=0;
        while(mindiff<=maxdiff){
            int mid=(mindiff+maxdiff)/2;
            int count=1;
            int cur=price[0];
            for(int i=1;i<price.length;i++){
                if(price[i]-cur>=mid){
                    cur=price[i];
                    count++;
                }
            }
            if(count>=k){
                res=mid;
                mindiff=mid+1;
            }else{
                maxdiff=mid-1;
            }
        }
        return res;
    }
}