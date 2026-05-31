class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long k=mass;
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>k){
                return false;
            }
            k=k+asteroids[i];
        }
        return true;
    }
}