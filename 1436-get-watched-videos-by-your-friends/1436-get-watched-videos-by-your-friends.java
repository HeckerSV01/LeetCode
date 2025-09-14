class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watched, int[][] friends, int id, int level) {
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[friends.length];
        q.add(id);
        vis[id]=1;
        int i=0;
        while(!q.isEmpty()&&i<level)
        {
            int size=q.size();
            for(int k=0;k<size;k++)
            {
                int curr=q.remove();
                for (int f:friends[curr]) {
                    if (vis[f]==0) {
                        q.add(f);
                        vis[f]=1;
                    }
                }
            }
            i++;
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(int k:q)
        {            
            for(String st:watched.get(k))
            {
                map.put(st,map.getOrDefault(st,0)+1);
            }
        }
        List<String> res=new ArrayList<>(map.keySet());
        Collections.sort(res,(a,b)->{
            int x=map.get(a);
            int y=map.get(b);
            if(x==y)
            {
                return a.compareTo(b);
            }
            return x-y;
        });
        return res;
    }
}