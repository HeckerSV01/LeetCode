class Solution {
    public String[] createGrid(int m, int n) {
        String res[]=new String[m];
        for(int i=0;i<m;i++){
            String s="";
            for(int j=0;j<n;j++){
                if(i==0){
                    s=s+".";
                }else{
                    if(j==n-1){
                        s=s+'.';
                    }else{
                        s=s+'#';
                    }
                }
            }
            res[i]=s;
        }
        return res;
    }
}