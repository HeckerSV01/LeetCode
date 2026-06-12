class Solution {
    public List<Integer> partitionLabels(String s) {
        int arr[][]=new int[26][2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=-1;
            }
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(arr[c-'a'][0]==-1){
                arr[c-'a'][0]=i;
            }
            arr[c-'a'][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]!=-1){
                idx=i;
                break;
            }
        }
        List<Integer> res=new ArrayList<>();
        int curr[]=arr[idx];
        for(int i=idx+1;i<arr.length;i++){
            if(curr[1]<=arr[i][0]){
                res.add(curr[1]-curr[0]+1);
                curr[0]=arr[i][0];
                curr[1]=arr[i][1];
            }else{
                curr[1]=Math.max(curr[1],arr[i][1]);
            }
        }
        res.add(curr[1]-curr[0]+1);
        return res;
    }
}