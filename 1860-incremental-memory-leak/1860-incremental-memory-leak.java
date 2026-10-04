class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int a1=memory1;
        int a2=memory2;
        int time=1;
        while(a1>=time||a2>=time){
            if(a1>=a2){
                a1-=time;
            }else{
                a2-=time;
            }
            time++;
        }
        return new int[]{time,a1,a2};
    }
}