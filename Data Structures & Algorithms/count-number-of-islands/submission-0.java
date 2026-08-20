class Solution {
    public int numIslands(char[][] grid) {
        // [0,0,1,0]
        // [0, 1,0,0]
        // [1,1,1,0] -> 3

        // 0 < grid.len;grdi[i].len < 100?
        // grid[i][j] = 1|0
        // build a tree
        //DFS, mark visited, until no 1s or boundaries found -> count++
        // use backtracking
        //data structs:
        // visited storage m*n
        // O(n*m) 
        // storage O(n*m)
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1')
                {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    private void dfs(char[][]grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        boolean canMoveLeft = j > 0 && !visited[i][j - 1] && grid[i][j - 1] == '1';
        boolean canMoveRight = j < grid[i].length - 1 && !visited[i][j + 1] && grid[i][j + 1] == '1';
        boolean canMoveUp = i > 0 && !visited[i - 1][j] && grid[i - 1][j] == '1';
        boolean canMoveDown = i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] == '1';

        if (canMoveLeft) dfs(grid, i, j - 1, visited);
        if (canMoveRight) dfs(grid, i, j + 1, visited);
        if (canMoveUp) dfs(grid, i - 1, j, visited);
        if (canMoveDown) dfs(grid, i + 1, j, visited);
    }
}
