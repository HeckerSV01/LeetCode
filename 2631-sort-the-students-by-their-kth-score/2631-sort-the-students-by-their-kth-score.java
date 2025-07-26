class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int temp[];
        for(int i=0;i<score.length;i++)
        {
            for(int j=0;j<score.length-i-1;j++)
            {
                if(score[j][k]<score[j+1][k])
                {
                    temp=score[j];
                    score[j]=score[j+1];
                    score[j+1]=temp;
                }
            }
        }
        return score;
    }
}