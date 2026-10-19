class MyCalendar {
    List<int[]> ranges;

    public MyCalendar() {
        ranges = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] p : ranges) {
            if (startTime < p[1] && endTime > p[0]) {
                return false;
            }
        }
        ranges.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */