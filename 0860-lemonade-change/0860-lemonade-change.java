class Solution {
    public boolean lemonadeChange(int[] nums) {
        int count5=0;
        int count10=0;
        int count20=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==5){
                count5++;
            }else if(nums[i]==10){
                count10++;
                if(count5>=1){
                    count5--;
                }else{
                    return false;
                }
            }else{
                count20++;
                if(count10<3&&count5>=3){
                    count5=count5-3;
                }else if(count10>=1&&count5>=1){
                    count10--;
                    count5--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}