class robot implements Comparable<robot>{
    int pos;
    int health;
    char dir;
    int idx;
    public robot(int pos,int health,char dir,int idx){
        this.pos=pos;
        this.health=health;
        this.dir=dir;
        this.idx=idx;
    }
    @Override
    public int compareTo(robot other) {
        return Integer.compare(this.pos, other.pos);
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        char dirn[]=directions.toCharArray();
        List<robot> list=new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            list.add(new robot(positions[i],healths[i],dirn[i],i));
        }
        Collections.sort(list);
        Stack<robot> st=new Stack<>();
        for(int i=0;i<list.size();i++){
            robot curr=list.get(i);
            while(!st.isEmpty()&&st.peek().dir=='R'&&list.get(i).dir=='L'){
                robot top=st.peek();
                if(top.health>curr.health){
                    curr.health=0;
                    top.health--;
                    break;
                }else if(top.health<curr.health){
                    st.pop();
                    curr.health--;
                }else{
                    st.pop();
                    curr.health=0;
                    break;
                }
            }
            if(curr.health>0){
                st.push(curr);
            }else{
                continue;
            }
        }
        List<robot> survivors=new ArrayList<>(st);
        Collections.sort(survivors,(a,b)->a.idx-b.idx);
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<survivors.size();i++){
            res.add(survivors.get(i).health);
        }
        return res;
    }
}