class Solution {
    public long subArrayRanges(int[] nums) {
        int nse[]=new int[nums.length];
        int pse[]=new int[nums.length];
        int nge[]=new int[nums.length];
        int pge[]=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i]=-1;
            }else{
                pge[i]=st.peek();
            }
            st.push(i);
        }
        long s1=0;
        long s2=0;
        for(int i=0;i<nums.length;i++){
            long ls=i-pse[i];
            long rs=nse[i]-i;
            long lg=i-pge[i];
            long rg=nge[i]-i;
            s1=s1+(rs*ls)*nums[i]*1L;
            s2=s2+(lg*rg)*nums[i]*1L;
        }
        return s2-s1;
    }
}