class Solution {
    public List<String> buildArray(int[] target, int n) {
        int number=1;
        ArrayList<String> l=new ArrayList<>();
        for(int i=0;i<target.length;i++)
        {
            while(number<target[i])
            {
               l.add("Push");
               l.add("Pop");
               number++;
            } 
            l.add("Push");
            number++;
        }
        return l;
    }
}