class Solution {
    private boolean issorted(int a[]){
        for(int i=0;i<a.length;i++){
            if(a[i]!=i+1){
                return false;
            }
        }
        return true;
    }

    private int findmaxidx(int[] a, int max, int end) {
        for (int i = 0; i <= end; i++) {
            if (a[i] == max) {
                return i;
            }
        }
        return -1;
    }
    private void reverse(int a[],int j){
        int i = 0;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        if(issorted(arr)){
            return new ArrayList<>();
        }
        List<Integer> res=new ArrayList<>();
        for (int max = arr.length; max > 1; max--) {

            int maxIdx = findmaxidx(arr, max, max - 1);
            if (maxIdx == max - 1) {
                continue;
            }
            if (maxIdx != 0) {
                res.add(maxIdx + 1);
                reverse(arr, maxIdx);
            }
            res.add(max);
            reverse(arr, max - 1);
        }

        return res;
    }
}