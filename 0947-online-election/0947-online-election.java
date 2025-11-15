class TopVotedCandidate {
int a[];
int times[];
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times=times;
        HashMap<Integer,Integer> map=new HashMap<>();
        a=new int[times.length];
        int top=-1;
        int max=0;
        for(int i=0;i<times.length;i++)
        {
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);
            if(map.get(persons[i])>=max)
            {
                top=persons[i];
                max=map.get(persons[i]);
            }
            a[i]=top;
        }
    }
    
    public int q(int t) {
        int st=0;
        int en=times.length-1;
        while(st<=en)
        {
            int mid=(st+en)/2;
            if(times[mid]>t)
            {
                en=mid-1;
            }
            else
            {
                st=mid+1;
            }
        }
        return a[en];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */