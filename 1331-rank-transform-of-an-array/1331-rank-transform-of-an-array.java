class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int temp[]=arr.clone();
        Arrays.sort(temp);
        int k=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<temp.length;i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i],k);
                k++;
            }
        }
        int res[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}