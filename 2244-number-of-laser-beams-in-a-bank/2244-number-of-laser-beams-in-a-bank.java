class Solution {
    public int numberOfBeams(String[] bank) {
        int res=0;
        ArrayList<Integer> l=new ArrayList<>();
        for(String s:bank)
        {
            int count=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='1')
                {
                    count++;
                }
            }
            if(count==0)
            {
                continue;
            }
            else
            {
                l.add(count);
            }
        }
        for(int i=1;i<l.size();i++)
        {
            res=res+l.get(i)*l.get(i-1);
        }
        return res;
    }
}