class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int x=rStart;
        int y=cStart;
        int res[][]=new int[rows*cols][2];
        int steps=1;
        HashMap<Character,int[]> map=new HashMap<>();
        map.put('N',new int[]{-1,0});
        map.put('S',new int[]{1,0});
        map.put('E',new int[]{0,1});
        map.put('W',new int[]{0,-1});
        res[0][0]=rStart;
        res[0][1]=cStart;
        int count=1;
        char dir='E';
        int idx=1;
        int check=0;
        while(idx<rows*cols){
            int d[]=map.get(dir);
            for(int i=0;i<steps;i++){
                x+=d[0];
                y+=d[1];
                if(x>=0&&x<=rows-1&&y>=0&&y<=cols-1){
                    res[idx][0]=x;
                    res[idx][1]=y;
                    idx++;
                }
            }
            if(dir=='E'){
                dir='S';
            }else if(dir=='S'){
                dir='W';
            }else if(dir=='W'){
                dir='N';
            }else if(dir=='N'){
                dir='E';
            }
            check++;
            if(check==2){
                check=0;
                steps++;
            }
        }
        return res;
    }
}