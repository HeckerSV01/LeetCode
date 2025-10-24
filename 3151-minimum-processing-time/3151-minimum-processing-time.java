class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks,Collections.reverseOrder());
        Collections.sort(processorTime);
        int timer=0;
        int idx=0;
        for(int i=0;i<processorTime.size();i++)
        {
            int k=tasks.get(idx);
            timer=Math.max(timer,processorTime.get(i)+k);
            idx=idx+4;
        }
        return timer;
    }
}