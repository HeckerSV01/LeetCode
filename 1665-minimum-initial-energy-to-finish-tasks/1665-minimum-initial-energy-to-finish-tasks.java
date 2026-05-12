class Solution {
    private boolean check(int a[][],int x){
        for(int i=0;i<a.length;i++){
            if(a[i][1]>x){
                return false;
            }
            x=x-a[i][0];
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int f=0;
        int l=Integer.MAX_VALUE/2;
        while(f<l){
            int mid=f+(l-f)/2;
            if(check(tasks,mid)){
                l=mid;
            }else{
                f=mid+1;
            }
        }
        return f;
    }
}