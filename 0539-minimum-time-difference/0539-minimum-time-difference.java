class Solution {
    public int findMinDifference(List<String> time) {
        Collections.sort(time);
        int minutes[]=new int[time.size()];
        for(int i=0;i<time.size();i++)
        {
            String s=time.get(i);
            int h=Integer.parseInt(s.substring(0,2));
            int m=Integer.parseInt(s.substring(3,5));
            minutes[i]=h*60+m;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<time.size()-1;i++)
        {
            min=Math.min(min,minutes[i+1]-minutes[i]);
        }
        min=Math.min(min,24*60-(minutes[time.size()-1]-minutes[0]));
        return min;
    }
}