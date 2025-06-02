class Solution {
int arr[];
int og[];
Random r;
int len;
    public Solution(int[] nums) {
        len=nums.length;
        arr=nums.clone();
        r=new Random();
        og=nums;
    }
    
    public int[] reset() {
        return og;
    }
    
    public int[] shuffle() {
        for(int i=len-1;i>=0;i--)
        {
            int k=r.nextInt(i+1);
            int temp=arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */