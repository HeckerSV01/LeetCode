class Allocator {
int a[];
    public Allocator(int n) {
        a=new int[n];
        Arrays.fill(a,-1);
    }
    
    public int allocate(int size, int mID) {
        if(size>a.length)
        {
            return -1;
        }
        int st=0;
        int en=0;
        int idx=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==-1)
            {
                idx++;
            }
            else
            {
                idx=0;
                st=i+1;
            }
            if(idx==size)
            {
                en=i;
                break;
            }
        }
        if(st>en)
        {
            return -1;
        }
        Arrays.fill(a,st,Math.min(en+1,a.length),mID);
        return st;
    }
    
    public int freeMemory(int mID) {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==mID)
            {
                count++;
                a[i]=-1;
            }
        }
        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */