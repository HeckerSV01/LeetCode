class Solution {
    public int maxDistance(String moves) {
        int hz=0;
        int ve=0;
        int count=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                ve--;
            }else if(moves.charAt(i)=='D'){
                ve++;
            }else if(moves.charAt(i)=='L'){
                hz--;
            }else if(moves.charAt(i)=='R'){
                hz++;
            }else{
                count++;
            }
        }
        return Math.abs(hz)+Math.abs(ve)+count;
    }
}