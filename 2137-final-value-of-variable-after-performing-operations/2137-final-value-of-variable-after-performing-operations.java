class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int sum=0;
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].charAt(1)=='+')
            {
                sum+=1;
            }
            else
            {
                sum+=-1;
            }
        }
        return sum;
    }
}