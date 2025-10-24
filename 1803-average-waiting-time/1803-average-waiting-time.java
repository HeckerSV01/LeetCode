class Solution {
    public double averageWaitingTime(int[][] customers) {
        long timer=0;
        int k=0;
        long sum=0;
        while(k<customers.length)
        {
            timer=Math.max(customers[k][0],timer);
            long fin=timer+customers[k][1];
            sum=sum+fin-customers[k][0];
            timer=fin;
            k++;
        }
        return (double)sum/customers.length;
    }
}