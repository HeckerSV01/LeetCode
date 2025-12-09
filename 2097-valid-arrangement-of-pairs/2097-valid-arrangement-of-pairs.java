class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer,Integer> indeg=new HashMap<>();
        HashMap<Integer,Integer> outdeg=new HashMap<>();
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<pairs.length;i++)
        {
            indeg.put(pairs[i][1],indeg.getOrDefault(pairs[i][1],0)+1);
            outdeg.put(pairs[i][0],outdeg.getOrDefault(pairs[i][0],0)+1);
            if(!adj.containsKey(pairs[i][0]))
            {
                adj.put(pairs[i][0],new ArrayList<>());
            }
            adj.get(pairs[i][0]).add(pairs[i][1]);
        }
        int n=pairs.length;
        int startnode=-1;
        int plus1=0;
        int minus1=0;
        for(int k:adj.keySet())
        {
            int diff=outdeg.getOrDefault(k,0)-indeg.getOrDefault(k,0);
            if(diff==1)
            {
                plus1++;
                startnode=k;
            }
            else if(diff==-1)
            {
                minus1++;
            }
        }
        if(plus1==0&&minus1==0)
        {
            for(int k:adj.keySet())
            {
                startnode=k;
                break;
            }
        }
        Stack<Integer> st=new Stack<>();
        List<int[]> list=new ArrayList<>();
        st.push(startnode);
        while(!st.isEmpty())
        {
            int node=st.peek();
            if(adj.containsKey(node)&&adj.get(node).size()>0)
            {
                int next=adj.get(node).remove(adj.get(node).size()-1);
                st.push(next);
            }
            else 
            {
                st.pop();
                if(!st.isEmpty())
                {
                    list.add(new int[]{st.peek(),node});
                }
            }
        }
        int[][] ans = new int[n][2];

        for (int i = 0; i < n; i++) {
            ans[i] = list.get(n - 1 - i);
        }

        return ans;
    }
}