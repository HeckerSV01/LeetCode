class Solution {
    public int maxProduct(String[] words) {
        int a[][]=new int[words.length][26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                a[i][words[i].charAt(j)-'a']=1;
            }
        }
        int res=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                boolean check=true;
                for(int k=0;k<26;k++){
                    if(a[i][k]==1&&a[j][k]==1){
                        check=false;
                    }
                }
                if(check){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}