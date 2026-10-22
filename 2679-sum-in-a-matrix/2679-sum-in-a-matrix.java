class Solution {
    public int matrixSum(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        for(int i=0;i<m;i++){
            Arrays.sort(nums[i]);
        }
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                temp[j]=nums[j][i];
            }
            Arrays.sort(temp);
            for(int j=0;j<m;j++){
                nums[j][i]=temp[j];
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[m-1][i];
        }
        return sum;
    }
}