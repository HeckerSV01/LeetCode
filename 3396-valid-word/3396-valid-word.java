class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)
        {
            return false;
        }
        String st="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        HashSet<Character> s=new HashSet<>();
        for(int i=0;i<st.length();i++)
        {
            s.add(st.charAt(i));
        }
        boolean res=true;
        int conso=0;
        int vow=0;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(!s.contains(c))
            {
                res=false;
                break;
            }
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
            {
                vow++;
            }
            else if(Character.isLetter(c))
            {
                conso++;
            }
        }
        if(vow==0||conso==0)
        {
            res=false;
        }
        return res;
    }
}