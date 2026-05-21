class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            int k=1;
            while(k<=arr1[i]){
                set.add((int)arr1[i]/k);
                k=k*10;
            }
        }
        int maxlen=0;
        for(int i=0;i<arr2.length;i++){
            int k=1;
            while(k<=arr2[i]){
                if(set.contains((int)(arr2[i]/k))){
                    int res=(int)Math.log10(arr2[i]/k)+1;
                    maxlen=Math.max(maxlen,res);
                    break;
                }
                k=k*10;
            }
        }
        return maxlen;
    }
}