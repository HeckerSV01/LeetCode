class Solution {
    public int sumSubarrayMins(int[] arr) {
        int nse[]=new int[arr.length];
        int pse[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
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
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        long res=0;
        final int mod=1000000007;
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            res=(res+(left*right%mod)*arr[i])%mod;
        }
        return (int)res;
    }
}