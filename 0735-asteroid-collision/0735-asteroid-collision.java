class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            boolean toAdd=true;
            while(!st.isEmpty()&&(nums[i]<0&&st.peek()>0)){
                if(Math.abs(nums[i])>Math.abs(st.peek())){
                    toAdd=true;
                    st.pop();
                }else if(Math.abs(nums[i])==Math.abs(st.peek())){
                    st.pop();
                    toAdd=false;
                    break;
                }else{
                    toAdd=false;
                    break;
                }
            }
            if(toAdd){
                st.push(nums[i]);
            }else{
                continue;
            }
        }
        int res[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
}