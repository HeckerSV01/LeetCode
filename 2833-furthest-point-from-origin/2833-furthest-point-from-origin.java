class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count=0;
        int count2=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='R'){
                count++;
            }else if(moves.charAt(i)=='L'){
                count--;
            }else{
                count2++;
            }
        }
        return Math.abs(count)+count2;
    }
}