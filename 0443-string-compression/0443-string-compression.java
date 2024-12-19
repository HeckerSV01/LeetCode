class Solution {
    public int compress(char[] chars) {
        
        String s="";
        for(int i=0;i<chars.length;i++)
        {
            Integer count=1;
            while(i<chars.length-1&&chars[i]==chars[i+1])
            {
              count++;
              i++;
            }
           s+=chars[i];
           if(count>1)
           {
            s+=count.toString();
           }
        }
        for(int i=0;i<s.length();i++)
        {
            chars[i]=s.charAt(i);
        }
        return s.length();
    }
}