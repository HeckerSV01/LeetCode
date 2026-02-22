class Solution {
    public int binaryGap(int n) {
        String s=Integer.toBinaryString(n);
        int max=0;
        List<Integer> idx=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                idx.add(i);
            }
        }
        for(int i=1;i<idx.size();i++){
            max=Math.max(max,idx.get(i)-idx.get(i-1));
        }
        return max;
    }
}