class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minendlandtime=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            minendlandtime=Math.min(minendlandtime,landStartTime[i]+landDuration[i]);
        }
        int finaltime1=Integer.MAX_VALUE;
        int finaltime2=Integer.MAX_VALUE;
        int minendwatertime=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            minendwatertime=Math.min(minendwatertime,waterStartTime[i]+waterDuration[i]);
            finaltime1=Math.min(finaltime1,Math.max(minendlandtime,waterStartTime[i])+waterDuration[i]);
        }
        for(int i=0;i<landStartTime.length;i++){
            finaltime2=Math.min(finaltime2,Math.max(minendwatertime,landStartTime[i])+landDuration[i]);
        }
        return Math.min(finaltime1,finaltime2);
    }
}