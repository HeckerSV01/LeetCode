class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        int n=arr.length;
        if(n==1){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],new HashSet<>());
            }
            map.get(arr[i]).add(i);
        }
        int vis[]=new int[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=1;
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.remove();
                if(cur==n-1){
                    return steps;
                }
                int idx1=cur+1;
                int idx2=cur-1;
                if(idx1>=0&&idx1<n&&vis[idx1]==0){
                    q.add(idx1);
                    vis[idx1]=1;
                }
                if(idx2>=0&&idx2<n&&vis[idx2]==0){
                    q.add(idx2);
                    vis[idx2]=1;
                }
                if(map.containsKey(arr[cur])){
                    for(int k:map.get(arr[cur])){
                        if(vis[k]==0){
                            vis[k]=1;
                            q.add(k);
                        }
                    }
                    map.remove(arr[cur]);
                }
            }
            steps++;
        }
        return -1;
    }
}