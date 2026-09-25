class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Character,int[]> map=new HashMap<>();
        map.put('N',new int[]{0,1});
        map.put('S',new int[]{0,-1});
        map.put('E',new int[]{1,0});
        map.put('W',new int[]{-1,0});
        int res=-1;
        char dir='N';
        int x=0;
        int y=0;
        HashSet<String> obs=new HashSet<>();
        for(int[] o:obstacles){
            obs.add(o[0]+","+o[1]);
        }
        for(Integer i:commands){
            if(i==-2){
                if(dir=='N'){
                    dir='W';
                }else if(dir=='S'){
                    dir='E';
                }else if(dir=='E'){
                    dir='N';
                }else if(dir=='W'){
                    dir='S';
                }
            }else if(i==-1){
                if(dir=='N'){
                    dir='E';
                }else if(dir=='S'){
                    dir='W';
                }else if(dir=='E'){
                    dir='S';
                }else if(dir=='W'){
                    dir='N';
                }
            }else{
                int dirn[]=map.get(dir);
                for(int j=0;j<i;j++){
                    x+=dirn[0];
                    y+=dirn[1];
                    if(obs.contains(x+","+y)){
                        x-=dirn[0];
                        y-=dirn[1];
                        break;
                    }
                }
            }
            res=Math.max(res,x*x+y*y);
        }
        return res;
    }
}