class Solution {
    public String largestGoodInteger(String num) {
        String max="";
        for(int i=0;i<=num.length()-3;i++)
        {
            String s=num.substring(i,i+3);
            if(s.charAt(0)==s.charAt(1)&&s.charAt(1)==s.charAt(2))
            {
                if(s.compareTo(max)>0)
                {
                    max=s;
                }
            }
        }
        return max;
    }
}