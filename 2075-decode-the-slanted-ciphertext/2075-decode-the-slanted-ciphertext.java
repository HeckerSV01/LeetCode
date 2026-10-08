class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols=encodedText.length()/rows;
        char a[][]=new char[rows][cols];
        int idx=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                a[i][j]=encodedText.charAt(idx);
                idx++;
            }
        }

        StringBuilder sb=new StringBuilder();

        for(int j=0;j<cols;j++){
            int k=j;
            for(int i=0;i<rows&&k<cols;i++){
                sb.append(a[i][k]);
                k++;
            }
        }

        return sb.toString().stripTrailing();
    }
}