class Solution {
    double r;
    double x;
    double y;
    public Solution(double radius, double x_center, double y_center) {
        this.r=radius;
        this.x=x_center;
        this.y=y_center;
    }
    
    public double[] randPoint() {
        Random rand=new Random();
        double angle=rand.nextDouble()*2*Math.PI;
        double rad=Math.sqrt(rand.nextDouble())*r;
        return new double[]{x+rad*Math.cos(angle),y+rad*Math.sin(angle)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */