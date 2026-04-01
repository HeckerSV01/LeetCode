class Solution {
    private int max(int a[][], int col) {
        int m = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][col] > a[m][col]) {
                m = i;
            }
        }
        return m;
    }

    public int[] findPeakGrid(int[][] mat) {
        int f = 0;
        int l = mat[0].length;
        while (f <= l) {
            int mid = f + (l - f) / 2;
            int rowmax = max(mat, mid);
            int left = (mid > 0) ? mat[rowmax][mid - 1] : -1;
            int right = (mid < mat[0].length - 1) ? mat[rowmax][mid + 1] : -1;
            if (left > mat[rowmax][mid]) {
                l = mid - 1;
            } else if (right > mat[rowmax][mid]) {
                f = mid + 1;
            } else {
                return new int[] { rowmax, mid };
            }
        }
        return new int[] { -1, -1 };
    }
}