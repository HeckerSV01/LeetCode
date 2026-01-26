class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            mindiff=Math.min(mindiff,arr[i+1]-arr[i]);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==mindiff){
                List<Integer> l=new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                res.add(l);
            }
        }
        return res;
    }
}