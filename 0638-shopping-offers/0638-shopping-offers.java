class Solution {
    private int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs,HashMap<List<Integer>,Integer> dp){
        if(dp.containsKey(needs)){
            return dp.get(needs);
        }
        int min=0;
        for(int i=0;i<needs.size();i++){
            min=min+needs.get(i)*price.get(i);
        }
        for(int i=0;i<special.size();i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<needs.size();j++){
                if(special.get(i).get(j)<=needs.get(j)){
                    temp.add(needs.get(j)-special.get(i).get(j));
                }else{
                    temp=null;
                    break;
                }
            }
            if(temp!=null){
                min=Math.min(min,special.get(i).get(special.get(i).size()-1)+solve(price,special,temp,dp));
            }
        }
        dp.put(needs,min);
        return min;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>,Integer> dp=new HashMap<>();
        return solve(price,special,needs,dp);
    }
}