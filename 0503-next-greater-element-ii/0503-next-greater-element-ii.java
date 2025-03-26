class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int n=nums.length;
        Stack<Integer> s=new Stack<>();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=-1;
        }
        for(int i=0;i<n*2;i++){
        while(!s.isEmpty() && nums[s.peek()] < nums[i%n])
        {
            arr[s.pop()]=nums[i%n];
        }
        if(i<n)
        {
            s.push(i);
        }
    }
    return arr; 
    }
}