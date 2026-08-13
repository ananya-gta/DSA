class Node {
    int r, c, d;
    Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<Node> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        // fill the queue and vis
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
                else {
                    vis[i][j] = false;
                }
            }
        }

        // until q is empty, visit neighbour in 4 directions and mark the ans 
        int[][] ans = new int[m][n];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().r;
            int col = q.peek().c;
            int dist = q.peek().d;
            q.remove();

            ans[row][col] = dist;
            for (int dir = 0; dir < 4; dir++) {
                int newR = row + dr[dir];
                int newC = col + dc[dir];
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && vis[newR][newC] == false) {
                    vis[newR][newC] = true;
                    q.add(new Node(newR, newC, dist + 1));
                }
            }
        }

        return ans;
    }
}