class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int space[]=new int[rocks.length];
        for(int i=0;i<rocks.length;i++){
            space[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(space);
        int count=0;
        for(int i=0;i<space.length&&additionalRocks>0;i++){
            if(space[i]==0){
                count++;
            }else if(space[i]<=additionalRocks){
                count++;
                additionalRocks=additionalRocks-space[i];
            }
        }
        return count;
    }
}