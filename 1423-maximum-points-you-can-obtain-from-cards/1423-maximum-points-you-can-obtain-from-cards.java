class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int r=cardPoints.length-1;
        int res=-1;
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+cardPoints[i];
            res=Math.max(res,sum);
        }
        for(int i=k-1;i>=0;i--){
            sum=sum-cardPoints[i];
            sum=sum+cardPoints[r];
            r--;
            res=Math.max(res,sum);
        }
        return res;
    }
}