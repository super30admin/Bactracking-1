//TC: O(m*n)
//SC: O(1)
class Solution {
    public int numIslands(char[][] grid) {
        // First way: DFS
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // check if this is an island
                // if it is then start searching from here
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    result ++;
                }
                // is water, so continue to next grid
            }
        }
        return result;
    }
    
    public void DFS(char[][] grid, int x, int y){
        
        // base case 1:
        // out of bound
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        
        // base case 2:
        // this is water, so finish this searching and return to parent
        if (grid[x][y] == '0') {
            return;
        }
        
         grid[x][y] = '0';
        DFS(grid, x-1, y);
        DFS(grid, x, y-1);
        DFS(grid, x+1, y);
        DFS(grid, x, y+1);
        
         }
}