class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int suma=0;
        for(int k[]:costs){
            suma=suma+k[0];
        }
        Arrays.sort(costs,(a,b)->a[1]-a[0]-(b[1]-b[0]));
        for(int i=0;i<costs.length/2;i++){
            suma=suma-costs[i][0]+costs[i][1];
        }
        return suma;
    }
}