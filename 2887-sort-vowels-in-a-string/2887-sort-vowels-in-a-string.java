class Solution {
    public String sortVowels(String s) {
        char c[]=s.toCharArray();
        List<Character> v=new ArrayList<>();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='A'||c[i]=='E'||c[i]=='I'||c[i]=='O'||c[i]=='U'||c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u')
            {
                v.add(c[i]);
            }
        }
        char vowel[]=new char[v.size()];
        int j=0;
        for(char k:v)
        {
            vowel[j++]=k;
        }
        Arrays.sort(vowel);
        j=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='A'||c[i]=='E'||c[i]=='I'||c[i]=='O'||c[i]=='U'||c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u')
            {
                c[i]=vowel[j++];
            }
        }
        return new String(c);
    }
}