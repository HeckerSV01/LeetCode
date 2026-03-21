class Solution {
    private int compatible(int a1[],int a2[]){
        int res=0;
        for(int i=0;i<a1.length;i++){
            if(a1[i]==a2[i]){
                res++;
            }
        }
        return res;
    }
    private int solve(int i,int a1[][],int a2[][],HashSet<Integer> set,HashMap<HashMap<Integer,String>,Integer> dp){
        if(i==a1.length){
            return 0;
        }
        HashMap<Integer,String> key=new HashMap<>();
        key.put(i,set.toString());
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int max=0;
        int res=0;
        for(int j=0;j<a2.length;j++){
            if(!set.contains(j)){
                set.add(j);
                int stud[]=a1[i];
                int men[]=a2[j];
                int compat=compatible(stud,men);
                res=compat+solve(i+1,a1,a2,set,dp);
                max=Math.max(max,res);
                set.remove(j);
            }
        }
        dp.put(key,max);
        return max;
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        HashSet<Integer> set=new HashSet<>();
        HashMap<HashMap<Integer,String>,Integer> dp=new HashMap<>();
        return solve(0,students,mentors,set,dp);
    }
}