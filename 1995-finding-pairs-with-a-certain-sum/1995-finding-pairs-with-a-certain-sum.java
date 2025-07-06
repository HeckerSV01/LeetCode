class FindSumPairs {
HashMap<Integer,Integer> map;
int a1[];
int a2[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        map=new HashMap<>();
        this.a1=nums1;
        this.a2=nums2;
        for(int i=0;i<nums2.length;i++)
        {
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int prev=a2[index];
        if(map.get(prev)==1)
        {
            map.remove(prev);
        }
        else
        {
            map.put(prev,map.get(prev)-1);
        }
        a2[index]=a2[index]+val;
        int newval=a2[index];
        if(!map.containsKey(newval))
        {
            map.put(newval,1);
        }
        else
        {
            map.put(newval,map.get(newval)+1);
        }
    }
    
    public int count(int tot) {
        int count=0;
        for(int i=0;i<a1.length;i++)
        {
            int comp=tot-a1[i];
            count=count+map.getOrDefault(comp,0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */