class Solution {
    public int hIndex(int[] citations) {
        int st=0;
        int en=citations.length;
        while(st<en)
        {
            int mid=(en+st)/2;
            if(citations[mid]>=citations.length-mid)
            {
                en=mid;
            }
            else
            {
                st=mid+1;
            }
        }
        return citations.length-st;
    }
}