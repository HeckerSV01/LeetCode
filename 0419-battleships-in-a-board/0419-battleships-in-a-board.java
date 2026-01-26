class Solution {
    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == '.' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i, j - 1);
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    count++;
                    dfs(board, visited, i, j);
                }
            }
        }
        return count;
    }
}