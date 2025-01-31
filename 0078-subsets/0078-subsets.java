class Solution {
    public static void subsets(int arr[],List<List<Integer>> main,List<Integer> list,int i)
    {
        if(i==arr.length)
        {
            main.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        subsets(arr,main,list,i+1);
        list.remove(list.size()-1);
        subsets(arr,main,list,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> main=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        subsets(nums,main,list,0);
        return main;
    }
}