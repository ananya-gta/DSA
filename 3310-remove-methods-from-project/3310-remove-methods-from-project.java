class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];         // {node -> [list of neighbours]}
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]); // {0 -> [2, 1], 1 -> [2], 2 -> [], 3 -> [4]}
        }

        boolean[] suspicious = new boolean[n];
        dfs (k, graph, suspicious);

        for (int[] edge : invocations) {
            int u = edge[0], v = edge[1];
            if (!suspicious[u] && suspicious[v]) { // cannot remove anything return 0...n-1
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        // return safe nodes
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;

    }

    public void dfs (int node, List<Integer>[] graph, boolean[] suspicious) {
        suspicious[node] = true;

        for (int neighbour : graph[node]) {
            if (!suspicious[neighbour]) {
                dfs(neighbour, graph, suspicious);
            }
        }
    }
}