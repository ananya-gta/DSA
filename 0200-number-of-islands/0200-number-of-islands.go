func numIslands(grid [][]byte) int {
	m := len(grid)
	n := len(grid[0])
	numOfIslands := 0
	visited := make([][]bool, m)
	for i := range visited {
		visited[i] = make([]bool, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' && visited[i][j] == false {
				numOfIslands++
				dfs(i, j, grid, visited)
			}
		}
	}
	return numOfIslands
}

func dfs(row int, col int, grid [][]byte, visited [][]bool) {
	m := len(grid)
	n := len(grid[0])
	visited[row][col] = true
    dR := []int{0, 1, 0, -1}
    dC := []int{1, 0, -1, 0}
    for i := 0; i < 4; i++ {
        newR := row + dR[i]
        newC := col + dC[i]
        if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == '1' && visited[newR][newC] == false) {
            dfs (newR, newC, grid, visited)
        }
    }
}