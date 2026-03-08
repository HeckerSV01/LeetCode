class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char res[]=new char[nums[0].length()];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            res[k++]=(char)(nums[i].charAt(i)^1);
        }
        return new String(res);
    }
}