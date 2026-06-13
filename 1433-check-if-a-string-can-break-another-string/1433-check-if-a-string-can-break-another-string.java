class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char a1[]=s1.toCharArray();
        char a2[]=s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        boolean b1=true;
        boolean b2=true;
        for(int i=0;i<a1.length;i++){
            if(a1[i]<a2[i]){
               b1=false; 
            }
            if(a2[i]<a1[i]){
                b2=false;
            }
        }
        return b1||b2;
    }
}