func remainingMethods(n int, k int, invocations [][]int) []int {
    graph := make([][]int, n)

    for _, edge := range invocations {
        u, v := edge[0], edge[1]
        graph[u] = append(graph[u], v)
    }

    suspicious := make([]bool, n)
    dfs(k, graph, suspicious)

    ans := []int{}

    for _, edge := range invocations {
        u, v := edge[0], edge[1]
        if !suspicious[u] && suspicious[v] { // check for safe -> suspicious
            for i := 0; i < n; i++ { // remove nothing, return 0...n-1
                ans = append(ans, i)
            }
            return ans;
        }
    }


    for i := 0; i < n; i++ {
        if !suspicious[i] {
            ans = append(ans, i)
        }
    }

    return ans
}

func dfs (node int, graph [][]int, suspicious []bool) {
    suspicious[node] = true
    for _, neighbour := range graph[node] {
        if !suspicious[neighbour] {
            dfs (neighbour, graph, suspicious)
        }
    }
}