class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int i=0;
        int k=1;
        int prevsum=0;
        int res=0;
        while(i+k<=grades.length){
            int j=i;
            int sum=0;
            while(j<Math.min(i+k,grades.length)){
                sum=sum+grades[j];
                j++;
            }
            if(sum<=prevsum){
                break;
            }
            i=j;
            prevsum=sum;
            k++;
            res++;
        }
        return res;
    }
}