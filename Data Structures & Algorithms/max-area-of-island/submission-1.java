class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // [[1,1,0,0,0]
        //  [1,1,0,0,0]
        //  [0,0,0,1,1]
        //  [0,0,0,1,1]]

        // 0 < grid.len;grdi[i].len < 100?
        // grid[i][j] = 1|0
        // build a tree
        //DFS, mark visited, until no 1s or boundaries found -> count++
        // use backtracking
        //data structs:
        // visited storage m*n
        // O(n*m) 
        // storage O(n*m)
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][]grid, int i, int j, boolean[][] visited) {
        int area = 1;
        visited[i][j] = true;
        boolean canMoveLeft = j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1;
        if (canMoveLeft) area += dfs(grid, i, j - 1, visited);

        boolean canMoveRight = j < grid[i].length - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1;
        if (canMoveRight) area += dfs(grid, i, j + 1, visited);

        boolean canMoveUp = i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 1;
        if (canMoveUp) area += dfs(grid, i - 1, j, visited);

        boolean canMoveDown = i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] == 1;
        if (canMoveDown) area += dfs(grid, i + 1, j, visited);
        return area;
    }
}
