class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if (!dq.isEmpty()&&dq.peekFirst()<i-k+1) {
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res.add(nums[dq.peekFirst()]);
            }
        }
        int a[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            a[i]=res.get(i);
        }
        return a;
    }
}