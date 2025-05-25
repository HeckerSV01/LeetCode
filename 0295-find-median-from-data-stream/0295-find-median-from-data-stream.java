class MedianFinder {
    ArrayList<Integer> list;
    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int idx=Collections.binarySearch(list,num);
        if(idx<0)
        {
            idx=-idx-1;
        }
        list.add(idx,num);
    }
    
    public double findMedian() {
        int n=list.size();
        if(n==1)
        {
            return (double)list.get(0);
        }
        if(n==2)
        {
            return (double)(list.get(0)+list.get(1))/2;
        }
        if(n%2==0)
        {
            return (double)(list.get(n/2)+list.get(n/2-1))/2;
        }
        return (double)list.get(n/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */