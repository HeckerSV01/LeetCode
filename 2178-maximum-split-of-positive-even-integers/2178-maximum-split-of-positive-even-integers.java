class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2!=0){
            return new ArrayList<>();
        }
        List<Long> res=new ArrayList<>(); 
        long k=finalSum;
        long maxeven=2;
        while(k>=maxeven){
            k=k-maxeven;
            res.add(maxeven);
            maxeven=maxeven+2;
        }
        res.set(res.size()-1,res.get(res.size()-1)+k);
        return res;
    }
}