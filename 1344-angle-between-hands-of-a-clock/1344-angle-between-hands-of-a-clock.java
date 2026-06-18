class Solution {
    public double angleClock(int hour, int minutes) {
        double min=minutes*6;
        double hr=hour*30+(minutes*0.5)%360.0;
        return Math.min(Math.abs(hr-min),360-Math.abs(hr-min));
    }
}