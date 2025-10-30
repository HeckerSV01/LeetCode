class Solution {
    public int numSplits(String s) {
        int res=0;
        int n=s.length();
        int left[]=new int[n];
        int right[]=new int[n];
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(s.charAt(i));
            left[i]=set.size();
        }
        set.clear();
        for(int i=n-1;i>=0;i--)
        {
            set.add(s.charAt(i));
            right[i]=set.size();
        }
        for(int i=0;i<n-1;i++)
        {
            if(left[i]==right[i+1])
            {
                res++;
            }
        }
        return res;
    }
}