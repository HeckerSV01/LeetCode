class Solution {
    public long smallestNumber(long num) {
        long res=0;
        if(num<0)
        {
            String s=String.valueOf(Math.abs(num));
            char a[]=s.toCharArray();
            Arrays.sort(a);
            for(int i=0,j=a.length-1;i<j;i++,j--) 
            { 
                char temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
            res=-(Long.parseLong(String.valueOf(a)));
        }
        else
        {
            String s=String.valueOf(num);
            char a[]=s.toCharArray();
            Arrays.sort(a);
            int i=0;
            while(i<a.length&&a[i]=='0')
            {
                i++;
            }
            if(i>=0&&i<a.length)
            {
                char temp=a[i];
                a[i]='0';
                a[0]=temp;
            }
            res=(Long.parseLong(String.valueOf(a)));
        }
        return res;
    }
}