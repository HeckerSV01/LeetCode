class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0;
        int r=0;
        int count1=0;
        StringBuilder res=new StringBuilder();
        while(r<s.length()){
            if(s.charAt(r)=='1'){
                count1++;
            }
            while(count1>k){
                if(s.charAt(l)=='1'){
                    count1--;
                }
                l++;
            }
            if(count1==k){
                while(s.charAt(l)=='0'){
                    l++;
                }
                StringBuilder temp=new StringBuilder(s.substring(l,r+1));
                if(res.isEmpty()||res.length()>temp.length()||(res.length()==temp.length()&&res.compareTo(temp)>0)){
                    res=temp;
                }
            }
            r++;
        }
        return res.toString();
    }
}