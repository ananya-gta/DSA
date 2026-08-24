class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            dfs(0, j, board, visited);
            dfs(m-1, j, board, visited);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, board, visited);
            dfs(i, n-1, board, visited);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void dfs (int r, int c, char[][] board, boolean[][] visited) {
        if (board[r][c] != 'O' || visited[r][c]) {
            return;
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        visited[r][c] = true;
        int m = board.length, n = board[0].length;
        for (int dir = 0; dir < 4; dir++) {
            int newR = dr[dir] + r;
            int newC = dc[dir] + c;
            if (newR >= 0 && newR < m && newC >= 0 && newC < n && board[newR][newC] == 'O' && visited[newR][newC] == false) {
                dfs(newR, newC, board, visited);
            }
        }
    }
}