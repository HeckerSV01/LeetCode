class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        int i=0;
        while(list.size()>1)
        {
            int no=list.size();
            i=(i+k-1)%no;
            list.remove(i);
        }
        return list.get(0);
    }
}