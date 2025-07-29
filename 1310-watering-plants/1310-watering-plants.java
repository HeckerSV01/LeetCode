class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int k=capacity;
        int idx=-1;
        int i=0;
        int steps=0;
        while(idx<plants.length-1)
        {
            if(capacity>=plants[i])
            {
                capacity=capacity-plants[i];
                idx++;
                i++;
                steps++;
            }
            else
            {
                steps=steps+2*(idx+1);
                capacity=k;
            }
        }
        return steps;
    }
}