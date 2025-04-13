class Solution {
    public static int getbulls(String s1,String s2)
    {
        int bulls=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==s2.charAt(i))
            {
                bulls++;
            }
        }
        return bulls;
    }
    public static int getcows(String s1,String s2)
    {
        int aux1[]=new int[10];
        int aux2[]=new int[10];
        for(int i=0;i<s1.length();i++)
        {
            aux1[s1.charAt(i)-'0']++;
            aux2[s2.charAt(i)-'0']++;
        }
        int total=0;
        for(int i=0;i<10;i++)
        {
            while(aux1[i]>0&&aux2[i]>0)
            {
               total++;
               aux1[i]--;
               aux2[i]--;
            }
        }
        return total-getbulls(s1,s2);
    }
    public String getHint(String secret, String guess) {
        return getbulls(secret,guess)+"A"+getcows(secret,guess)+"B";
    }
}