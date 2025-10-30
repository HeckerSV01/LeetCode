class Solution {
    public String replaceWords(List<String> dictionary, String s) {
        Collections.sort(dictionary,(a,b)->a.length()-b.length());
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int st=i;
            while(i<n&&s.charAt(i)!=' ')
            {
                i++;
            }
            int en=i;
            String str=s.substring(st,en);
            boolean check=false;
            for(String strr:dictionary)
            {
                if(str.startsWith(strr))
                {
                    sb.append(strr+" ");
                    check=true;
                    break;
                }
            }
            if(!check)
            {
                sb.append(str+" ");
            }
        }
        return sb.toString().trim();
    }
}