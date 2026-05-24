class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int freq[]=new int[101];
        for(int i:nums){
            freq[i]++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<101;i++){
            if(freq[i]>=1&&freq[i]>=k){
                for(int j=0;j<k;j++){
                    list.add(i);
                }
            }else if(freq[i]>=1&&freq[i]<k){
                for(int j=0;j<freq[i];j++){
                    list.add(i);
                }
            }
        }
        int res[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}